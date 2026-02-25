import os
import sys

# Set the environment variables to the current Python executable
os.environ['PYSPARK_PYTHON'] = sys.executable
os.environ['PYSPARK_DRIVER_PYTHON'] = sys.executable

from pyspark.sql import SparkSession
from pyspark.sql.functions import col

spark = (
    SparkSession.builder
    .appName("Day2Intro")
    .master("local[*]")
    .getOrCreate()
)

data = [
    {"user_id": 123, "event_type": "click", "timestamp": "2024-01-01T10:00:00Z"},
    {"user_id": 456, "event_type": "view", "timestamp": "2024-01-01T10:05:00Z"},
    {"user_id": 789, "event_type": "click", "timestamp": "2024-01-01T10:10:00Z"},
]

df = spark.createDataFrame(data)
df.show()
df.printSchema()



clicks = df.filter(col("event_type") == "click")
clicks.show()

spark.stop()