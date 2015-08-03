# ridePool
Restful webservice for sharing ride

End poings:

1. Registration for using application
http://localhost:8080/ridePool/api/register
application/json
{
  "name": "kavya",
  "email": "Kavya@gmail.com",
  "gender": "female",
  "phone":"9880321906",
  "password": "12345"
}

2. Offer ride : If you are travelling in your vehicle, you can offer this ride to other
http://localhost:8080/ridePool/rest/api/offerRide
application/json
{
  "from": "SAP Labs",
  "to": "JP Nagar",
  "via": "Outer Ring",
  "userEmail":"SKavya@gmail.com"
}

3. Find available rides offered others
http://localhost:8080/ridePool/rest/api/findRide 
application/json
{
  "from": "SAP Labs",
	"to": "Vijayanagar",
  "via": "OuterRingRoad" 
}
