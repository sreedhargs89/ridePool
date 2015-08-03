# ridePool
Restful webservice for sharing ride

End poings:</br>
** Registration for using application</br>
http://localhost:8080/ridePool/api/register</br>
application/json</br>
{</br>
  "name": "kavya",</br>
  "email": "Kavya@gmail.com",</br>
  "gender": "female",</br>
  "phone":"9880321906",</br>
  "password": "12345"</br>
}</br>

** Offer ride : If you are travelling in your vehicle, you can offer this ride to other</br>
http://localhost:8080/ridePool/rest/api/offerRide</br>
application/json</br>
{</br>
  "from": "SAP Labs",</br>
  "to": "JP Nagar",</br>
  "via": "Outer Ring",</br>
  "userEmail":"SKavya@gmail.com"</br>
}</br>

** Find available rides offered others</br>
http://localhost:8080/ridePool/rest/api/findRide</br>
application/json</br>
{</br>
  "from": "SAP Labs",</br>
  "to": "Vijayanagar",</br>
  "via": "OuterRingRoad"</br> 
}</br>
