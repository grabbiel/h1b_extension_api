# H1B Sponsor Checker (API)
RestFUL API serving as both requests endpoints and a Kafka topics producer.

The service contains an ORM model linked to the main table ("h1b_records") within the database used by the browser extension "H1B Sponsor Checker".

![H1B Records Table](https://raw.githubusercontent.com/pakitow/pakitow/main/images-repository/table-records.png "Table Records Snippet")

The API has 4 endpoints (3 GET and 1 POST mapping). 
##### [1] "/has_match" 
Returns a boolean to the client, indicating whether a company in question was found among the past records of visa sponsors.
##### [2] "/literal_match" 
Returns the string literal that matches with at least one record in the database, as sometimes the names used by job board websites like Indeed or LinkedIn do not match the data provided by UCSIS
##### [3] "/record" 
Returns a JSON object containing relevant information on a particular sponsor, e.g., visa requests, visa approvals and ranking.
##### [4] "/text-analysis" 
Receives a JSON object containing a particular job description, its preliminary classification*, and the company posting the job opening; it then sends a message to a Kafka broker in charge of redirecting it to another text-analyzer microservice.

![H1B Records Table Schema](https://raw.githubusercontent.com/pakitow/pakitow/main/images-repository/table-schema.png "Table Schema")

The microservice (as a producer) only publishes to the **"match_review"** topic.

The queries performed by the JPA repository are mostly JPA derived queries.

The most frequent query requests are cached, i.e., 
1. getting a string literal match for a website company name; and, 
2. getting the sponsoring status of a company. 

The caching mechanism is dependent upon a connection to a Redis instance set up in an EC2 VM.