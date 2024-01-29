# spring-microservice-demo 

Sample Microservice Application with:  
Order Microservice   
Bookkeeping or Catalog Microservice   
Config Server  
Gateway Microservice     

To run, ensure tilt, kubernetes, and docker are installed and running.    

On cli, from project root directory, do `tilt up` to run the microservices. 

Also on cli, if you have httpie installed (`brew install httpie`), do the following:  

`http POST http://localhost:9001/books author="kehinde" publisher="adetiloye"`   
`isbn="1232323232" price=9.90 title="Hi"`. 

`http GET http://localhost:9001/books`.

to make post and get request to catalog endpoint.

To make a post request to the Order endpoint do:   
`http POST http://localhost:9002/orders isbn="1232323232" quantity=2`

To undeploy microservices do `tilt down`.
