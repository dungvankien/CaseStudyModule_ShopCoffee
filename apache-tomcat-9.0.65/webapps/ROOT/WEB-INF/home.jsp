<<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
  <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
  <link rel="stylesheet" href="/assets/css/all.min.css">
</head>
<body>
<div  class="container-fluid">
  <div class="row">
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Logo</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
          <ul class="navbar-nav me-auto">
            <li class="nav-item">
              <a class="nav-link" href="javascript:void(0)">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="javascript:void(0)">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="javascript:void(0)">Link</a>
            </li>
          </ul>
          <form class="d-flex">
            <input style="width: 400px"  class="form-control me-2" type="text" placeholder="Search">
            <button class="btn btn-primary" type="button">Search</button>
          </form>
        </div>
      </div>
    </nav>

    <div id="carouselExampleDark" class="carousel carousel-dark slide bg-dark" data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="1000">
          <img height="250px" src="https://zerovn.net/anh-bia-ban-quan-ao/imager_5_25534_700.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h5>First slide label</h5>
            <p>Some representative placeholder content for the first slide.</p>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="500">
          <img height="250px" src="https://zerovn.net/anh-bia-ban-quan-ao/imager_5_25534_700.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h5>Second slide label</h5>
            <p>Some representative placeholder content for the second slide.</p>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="5000">
          <img height="250px" src="https://zerovn.net/anh-bia-ban-quan-ao/imager_5_25534_700.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h5>Third slide label</h5>
            <p>Some representative placeholder content for the third slide.</p>
          </div>
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>

    <section class="container pt-md-3 pb-5 mb-md-3">
      <div class="row pt-4 mx-n2">
        <!-- Product-->
        <c:forEach var="item" items="${productList}">
          <div class="col-lg-3 col-md-4 col-sm-6 px-2 mb-4">
            <div class="card product-card">
              <a class="card-img-top d-block overflow-hidden text-center" href="#"><img width="auto" height="250px" src="${item.getImage()}" alt="Product"></a>
              <div class="card-body py-2">
                <h3 class="product-title fs-sm text-center"><a href="#">${item.getNameProduct()}</a></h3>
                <div class="d-flex justify-content-between">
                  <div class="product-price text-center"><span class="text-accent">Price: ${item.getPrice()}</span></div>
                </div>
              </div>
              <div class="card-body">
                <button class="btn btn-primary btn-sm d-block w-100 mb-2" type="button"><i class="fa-solid fa-cart-plus"></i></i>  Add to Cart</button>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </section>

    <nav class="navbar navbar-expand-sm navbar-dark bg-dark justify-content-end">
      <ul class="nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Active</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Disabled</a>
        </li>
      </ul>
    </nav>
  </div>

</div>


<script src="assets/js/bootstrap.bundle.js"></script>
<script>
  var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
  var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
    return new bootstrap.Popover(popoverTriggerEl)
  })
</script>
</body>
</html>
