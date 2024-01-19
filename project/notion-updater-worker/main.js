const { Client } = require("@notionhq/client")
require('dotenv').config()

// Initializing a client
const notion = new Client({
  auth: process.env.NOTION_TOKEN,
});

async function getInProgressEvents () {
	const inProgressEvents = await notion.databases.query({
		database_id: process.env.BASE_DATABASE_ID,
		filter: {
			and: [
				{
					"property": "종료됨",
					"checkbox": {
						"equals": false
					}
				}, 
			]
		}
	})
	return inProgressEvents
}


async function main() {
	const inProgressEvents = await getInProgressEvents();
	console.log(inProgressEvents.results.length);
}

main()