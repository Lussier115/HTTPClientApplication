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
GET -v  http://httpbin.org/get
`

`
GET -v  http://httpbin.org/absolute-redirect/3 -o /home/wlussier/Projects/HTTPClientApplication/sampleFiles/output.txt 
`

`
GET -v  http://httpbin.org/absolute-redirect/3
`

`
GET http://httpbin.org/get?course=networking&assignment=1 
`

`
GET -h "User-Agent: Hello" http://httpbin.org/status/418
`

`
GET -h "User-Agent: Hello" http://httpbin.org/status/418 -o /home/wlussier/Projects/HTTPClientApplication/sampleFiles/teapot.txt 
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