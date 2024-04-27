# spring-microservice-demo 

Sample Microservice Application with:  
Order Microservice   
Bookkeeping or Catalog Microservice   
Config Server  
Gateway Microservice     

To run, on cli, from project root directory, do `tilt up` to startup microservices. 

Also on cli, if you have httpie installed (`brew install httpie`), do the following:  

`http POST http://localhost:9001/books author="kehinde" publisher="adetiloye"`   
`isbn="1232323232" price=9.90 title="Hi"`. 

`http GET http://localhost:9001/books`.

to make post and get request to catalog endpoint.

To undeploy microservices do `tilt down`.

Ensure, tilt, kubernetes, docker, httpie are installed.
