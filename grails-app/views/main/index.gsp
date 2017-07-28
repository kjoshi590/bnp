<div class="container">
    <h1> Welcome to BnP: ${user.firstName}</h1>

    <a class="btn btn-primary" href="/booking/create">Book Court</a>
    <a class="btn btn-success" href="/booking/index">View Bookings</a>

    <h3>Your Latest booking:</h3>
     ${bookings.last().dateOfBooking}
</div>



