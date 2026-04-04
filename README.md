<h1 align="center">✈️ Flight Booking System</h1>

<p align="center">
  <b>Industry-Level Backend System | Spring Boot | Scalable Architecture</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge" />
  <img src="https://img.shields.io/badge/SpringBoot-3.x-brightgreen?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Database-MySQL-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Architecture-Monolith-yellow?style=for-the-badge" />
  <img width="791" height="871" alt="system design for flight app" src="https://github.com/user-attachments/assets/59d02219-a190-4dee-84c1-fb34eb203329" />

</p>

<hr/>

<h2>🚀 Project Overview</h2>

<p>
This project is a <b>real-world, industry-level Flight Booking Backend System</b> inspired by platforms like MakeMyTrip.
It is designed with scalability, clean architecture, and real-world booking workflows in mind.
</p>

<ul>
  <li>✔ Flight Search & Filtering</li>
  <li>✔ Seat Inventory Management</li>
  <li>✔ Booking Flow Design (Upcoming)</li>
  <li>✔ Airport Food & Restaurant Discovery</li>
  <li>✔ Scalable for Microservices Migration</li>
</ul>

<hr/>

<h2>✨ Core Features</h2>

<h3>🛫 Flight Management</h3>
<ul>
  <li>Add, Update, Delete Flights</li>
  <li>Search flights by Source & Destination</li>
  <li>Real-time filtering & sorting</li>
  <li>Pagination for large datasets</li>
</ul>

<h3>🔍 Smart Flight Search</h3>
<ul>
  <li>Filter by Source, Destination</li>
  <li>Sort by Price, Departure Time, Arrival Time</li>
  <li>Optimized query handling</li>
  <li>Scalable search design (ready for caching)</li>
</ul>

<h3>💺 Seat Inventory System</h3>
<ul>
  <li>Seat-level tracking (no static seat count)</li>
  <li>Seat Classes: Economy, Business</li>
  <li>Seat Status:
    <ul>
      <li>Available</li>
      <li>Locked (during booking)</li>
      <li>Booked</li>
    </ul>
  </li>
  <li>Prevents double booking (design-ready)</li>
</ul>

<h3>📖 Booking Workflow (Design Ready)</h3>
<ul>
  <li>Select Flight → Select Seats → Booking → Payment → Confirmation</li>
  <li>Seat locking mechanism (planned)</li>
  <li>Multi-passenger booking support</li>
  <li>Booking status lifecycle handling</li>
</ul>

<h3>🍽️ Airport Food & Restaurant Tracking (Advanced Feature)</h3>
<ul>
  <li>Discover nearby food shops and restaurants at selected airports</li>
  <li>Enhances travel experience with food availability insights</li>
  <li>Future-ready for:
    <ul>
      <li>Distance-based recommendations</li>
      <li>Ratings & reviews</li>
      <li>Third-party API integration (Google Places / Zomato)</li>
    </ul>
  </li>
</ul>

<h3>⚠️ Exception Handling</h3>
<ul>
  <li>Custom exception classes</li>
  <li>Proper HTTP status responses</li>
  <li>Centralized error handling</li>
</ul>

<hr/>

<h2>🧱 Tech Stack</h2>

<ul>
  <li><b>Backend:</b> Spring Boot</li>
  <li><b>Language:</b> Java</li>
  <li><b>Database:</b> MySQL / PostgreSQL</li>
  <li><b>ORM:</b> Hibernate (JPA)</li>
  <li><b>Build Tool:</b> Maven</li>
  <li><b>Utilities:</b> Lombok</li>
</ul>

<hr/>

<h2>📂 Project Structure</h2>

<pre>
src/main/java/org/flightservice
│── controller
│── service
│── repository
│── entity
│── exception
│── dto (planned)
│── config (planned)
</pre>

<hr/>

<h2>🔗 API Endpoints</h2>

<h3>Flight APIs</h3>

<table>
  <tr>
    <th>Method</th>
    <th>Endpoint</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>POST</td>
    <td>/flights/add</td>
    <td>Add new flight</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/flights/allFlights</td>
    <td>Get all flights</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/flights/get/{id}</td>
    <td>Get flight by ID</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/flights/update/{id}</td>
    <td>Update flight</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/flights/delete/{id}</td>
    <td>Delete flight</td>
  </tr>
</table>

<h3>🔍 Search API</h3>

<pre>
GET /flights/search?source=BLR&destination=DEL&page=0&size=5&sort=price,asc
</pre>

<h3>💺 Seat API (In Progress)</h3>

<pre>
GET /flights/{flightId}/seats
</pre>

<hr/>

<h2>🧠 System Design</h2>

<pre>
Controller → Service → Repository → Database
</pre>

<ul>
  <li>✔ Clean layered architecture</li>
  <li>✔ Separation of concerns</li>
  <li>✔ Scalable for microservices transition</li>
</ul>

<hr/>

<h2>🎯 Future Enhancement</h2>

<ul>
  <li>
    Build a <b>modern, responsive UI using React</b> with:
    <ul>
      <li>Interactive flight search experience</li>
      <li>Microservice based architecture</li>
      <li>Real-time seat selection UI</li>
      <li>Booking & payment flow</li>
      <li>Integrated airport food & restaurant discovery</li>
    </ul>
  </li>
</ul>

<hr/>

<h2>⚙️ Setup & Run</h2>

<h3>1. Clone Repository</h3>

<pre>
git clone https://github.com/your-username/flight-booking-system.git
cd flight-booking-system
</pre>

<h3>2. Configure Database</h3>

<pre>
spring.datasource.url=jdbc:mysql://localhost:3306/flightdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
</pre>

<h3>3. Run Application</h3>

<pre>
mvn spring-boot:run
</pre>

<hr/>

<h2>👨‍💻 Author</h2>

<p>
<b>Atanu Das</b><br/>
Java Backend Developer
</p>

<hr/>

<h2>⭐ Support</h2>

<p>If you like this project, give it a ⭐ on GitHub!</p>
