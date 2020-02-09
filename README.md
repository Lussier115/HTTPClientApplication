HTTPClientApplication
## Students
William-Andrew Lussier (40033412)



## Tested Curl Commands

#### HELP

`help`

`help post`

`help get`

#### GET
`
GET http://httpbin.org/get?course=networking&assignment=1 
`

`
GET -h "User-Agent: Hello" http://httpbin.org/status/418
`

#### POST
`
POST -h Content-Type:application/json -d '{"Assignment": 1}' http://httpbin.org/post
`

`
POST -h Content-Type:application/json -d '{"Assignment": {"Page": 2, "Paragraph": 2}}' http://httpbin.org/post
`

`
POST -f /home/wlussier/Projects/HTTPClientApplication/sampleFiles/example.txt http://httpbin.org/post
`