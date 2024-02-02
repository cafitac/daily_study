import sqlite3

from datetime import datetime


def main():
    con = sqlite3.connect("db.sqlite3")
    cur = con.cursor()

    data = []

    for i in range(1000000):
        query = (None, 'password', None, False, f'username_{i}', f"first_name_username_{i}", f"last_name_username_{i}", f'username_{i}@gmail.com', False, True, datetime.now())
        data.append(query)

    cur.executemany(
        f"""INSERT INTO member_user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""",
        data
    )
    con.commit()
    con.close()


if __name__ == '__main__':
    main()
