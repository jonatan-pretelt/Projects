"""
The function should:
    Expect a single dict
    Validate required fields: "user_id" and "email"
    Normalize: email -> lowercase + trimmed
    if invalid raise ValueError with a clear message

"""

def normalize_user_record(record: dict) -> dict:
    required_fields =("user_id", "email")

    if not all(field in record for field in required_fields):
        raise ValueError("There are missing fields in this record")
    return {
        "user_id": record["user_id"],
        "email" : record["email"].strip().lower()
    }
    
input_record = {"user_id": 123, "email": " TEST@EXAMPLE.COM "}
print(normalize_user_record(input_record))

