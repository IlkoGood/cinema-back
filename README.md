<h1> Cinema ticket app </h1>

### Spring pet project for cinema back-end implements following abilities:
<table>
<tr>
<td>
<img src=https://user-images.githubusercontent.com/116804521/236665914-5af8d074-2bae-43f2-aa3b-0a7d36dc0ef3.jpg>
</td>
<td>
<ul>
<li>Session-based <b>authentication</b>, <b>encrypted password</b> storing in DB;</li>
<li>Role-based <b>authorization</b> for "admin" and "user;</li>
<li><b>Separated access</b> to endpoints for different roles;</li>
<li><b>Admin tools</b>: get customer info, add movies, cinema halls, manage movie sessions</li>
<li><b>Full customer cycle</b>: register, obtaing shopping cart, add tickets on movie session, complete order;</li>
<li>Currently deployed at AWS <b><a href="http://13.53.243.222:81/">CINEMA</a></b> (address may be changed, feel free to write me here in GitHub);</li>
</ul>
</td>
</tr>
</table>

## Structure description

<ul>
<li><code>controller</code>: controllers for endpoints (look startup steps)</li>
<li><code>dao</code>: Data Access Objects are responsible for correct CRUD operations with DB;</li>
<li><code>dto</code>: Data Response Objects are representing communication objects for customer requests and responses;</li>
<li><code>exception</code>: custom exception;</li>
<li><code>lib</code>: contains custom annotations and logic for email and password validation;</li>
<li><code>model</code>: Plain Old Java Objects are defining operational data (objects) type and sctructure;</li>
<li><code>service</code>: provides business logic, includes <code>mapper</code>-s for dto;</li>
<li><code>util</code>: utility class used to determine DateTime pattern;</li>
<li><code>resources</code>: contains configurational file with JDBC and Hibernate params.</li>
</ul>

## Startup steps

* Download this repo to destination without any gaps and non-latin symbols in path;
* Update <code>db.properties</code> in <code>resources</code> if necessary, otherwise it will work with in-memory DB emulation
* Build the project using<code>mvn clean package</code>
* Deploy the generated <code>cinema-back-1.0.war</code> image with servlet container such as Tomcat
* Use Postman for easy communication with program, here is map of endpoints: 
  * `POST /register` - register new user (non-auth access);
  * `GET /movie-sessions/available` - get list of sessions (user, admin);
  * `GET /cinema-halls` - get list of halls (user, admin);
  * `GET /users/by-email` - retrieve user's info (admin);
  * `POST`: `/cinema-halls` ,`/movies`, `/movie-sessions` - create corresponding objects (admin);
  * `PUT`, `DELETE` `/movie-sessions` - update and delete movie session (admin);
  * `GET /orders /shopping-carts/by-user` - show history of orders, list of tickets in cart (user);
  * `PUT /shopping-carts/movie-sessions` - put a ticket on this movie session to the cart (user);
  * `POST /orders/complete` - execute order (user);
* Built-in accounts: `admin@i.ua/admin12345`, `user@i.ua/user12345`

## Used stack

<table>
<tr>
<td width="700">
<ul>
<li>Java <code>17.0.5</code></li>
<li>Maven <code>3.10.1</code></li>
<li>Spring <code>5.3.20</code></li>
<li>Spring Security <code>5.6.10</code></li>
<li>Hibernate <code>5.6.14.Final</code></li>
<li>Hibernate Validator <code>6.1.6.Final</code></li>
<li>MySql Connector <code>8.0.32</code></li>
<li>HSQLDB <code>2.7.1</code></li>
<li>Javax Servlets <code>4.0.1</code></li>
<li>Javax Annotations <code>1.3.2</code></li>
<li>Tomcat <code>9.0.73</code></li>
</ul>
</td>
<td>
<img src=https://user-images.githubusercontent.com/116804521/236665921-e5f11b0d-9434-48c6-9b3a-a48c24f0c221.jpg>
</td>
</tr>
</table>
