const { Client } = require("@notionhq/client")
require('dotenv').config()

// Initializing a client
const notion = new Client({
    auth: process.env.NOTION_TOKEN,
});

async function getInProgressEvents() {
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
    return inProgressEvents.results
}

async function update_event_to_closed(event_id) {
    const resp = await notion.pages.update({
        page_id: event_id,
        properties: {
            "종료됨": { "checkbox": true }
        }
    })
}


async function main() {
    const today = new Date();
    const inProgressEvents = await getInProgressEvents();

    for (const event of inProgressEvents) {
        const competition_end_date = new Date(event.properties.competition_end_date.date.start)
        if (today > competition_end_date) {
            await update_event_to_closed(event.id)
        }
    }
}

main()