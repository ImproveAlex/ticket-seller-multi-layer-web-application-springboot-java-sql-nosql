<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>TicketSeller</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<div>
   


    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm px-5 py-3 py-lg-0">
        <a href="index.html" class="navbar-brand p-0">
            <h1 class="m-0 text-uppercase text-primary"><i class="far fa-smile text-primary me-2"></i>TicketSeller</h1>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto py-0 me-n3">
                <a href="index.html" class="nav-item nav-link">Home</a>
                <a href="service.html" class="nav-item nav-link">Advanced Search</a>
				<a href="service.html" class="nav-item nav-link">User</a>
                <a href="contact.html" class="nav-item nav-link active">Log Out</a>
            </div>
        </div>
    </nav>
    <!-- Navbar End -->


    <!-- Page Header Start -->
    <div class="container-fluid bg-dark p-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="display-4 text-white">Publica tu Evento</h1>
                
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- form Start -->
    <div class="container-fluid bg-secondary px-0" id="myDIV">
        <div class="row g-0">
            <div class="col-lg-6 py-6 px-5">
                <h1 class="display-5 mb-4">Introduzca los datos del Evento</h1>
                <form action="publicarEvento.html" method="post" id="request" class="main_form">
                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <input class="form-control" placeholder="Evento" type="type" name="evento">
                                <label for="">Evento</label>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <input class="form-control" placeholder="Categoría" type="type" name="categoría">
                                <label for="">Categoria</label>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <input class="form-control" placeholder="Fecha" type="type" name="fecha">
                                <label for="">Fecha</label>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <input class="form-control" placeholder="Ciudad" type="type" name="ciudad">
                                <label for="">Ciudad</label>
                              </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <input class="form-control" placeholder="Sala" type="type" name="sala">
                                <label for="">Sala</label>
                              </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <input class="form-control" id="foto" class="textarea" name="URL_foto" type="type" placeholder="URL Foto">
                                <label for="">URL de la foto</label>
                              </div>
                        </div>
						
						
                        <div class="col-6">
                            <button class="btn btn-primary w-100 py-3" onclick="publicarEvento()" type="submit">Publicar</button>
                        </div>
						
                    </div>
                </form>
            </div>
            
        </div>
    </div>
    <div class="container-fluid bg-secondary px-0" id="myDIV">
        <div class="row g-0">
            <div class="col-lg-6 py-6 px-5">
                <h1 class="display-5 mb-4" id="exito-publicar"></h1>
            </div>
            
        </div>
    </div>
    <!-- form End -->


    <!-- Footer Start -->
    
    <div class="container-fluid bg-dark text-secondary p-5">
        <div class="row g-5">
            
            <div class="col-lg-3 col-md-6">
                <h3 class="text-white mb-4">Popular Links</h3>
                <div class="d-flex flex-column justify-content-start">
                    <a class="text-secondary mb-2" href="#"><i class="bi bi-arrow-right text-primary me-2"></i>Home</a>
                    <a class="text-secondary mb-2" href="#"><i class="bi bi-arrow-right text-primary me-2"></i>Advanced Search</a>
                    <a class="text-secondary mb-2" href="#"><i class="bi bi-arrow-right text-primary me-2"></i>Log Out</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <h3 class="text-white mb-4">Get In Touch</h3>
                <p class="mb-2"><i class="bi bi-geo-alt text-primary me-2"></i>Spain, MADRID </p>
                <p class="mb-2"><i class="bi bi-envelope-open text-primary me-2"></i>info@example.com</p>
                <p class="mb-0"><i class="bi bi-telephone text-primary me-2"></i>Phone: 789548216</p>
            </div>
            <div class="col-lg-3 col-md-6">
                <h3 class="text-white mb-4">Follow Us</h3>
                <div class="d-flex">
                    <a class="btn btn-lg btn-primary btn-lg-square rounded-circle me-2" href="#"><i class="fab fa-twitter fw-normal"></i></a>
                    <a class="btn btn-lg btn-primary btn-lg-square rounded-circle me-2" href="#"><i class="fab fa-facebook-f fw-normal"></i></a>
                    <a class="btn btn-lg btn-primary btn-lg-square rounded-circle me-2" href="#"><i class="fab fa-linkedin-in fw-normal"></i></a>
                    <a class="btn btn-lg btn-primary btn-lg-square rounded-circle" href="#"><i class="fab fa-instagram fw-normal"></i></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid bg-dark text-secondary text-center border-top py-4 px-5" style="border-color: rgba(256, 256, 256, .1) !important;">
        <p class="m-0">&copy; <a class="text-secondary border-bottom" href="#">TicketSeller</a>. All Rights Reserved. Designed by <a class="text-secondary border-bottom" href="https://htmlcodex.com">HTML Codex</a></p>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        
    <!-- Template Javascript -->
    <script >
    function publicarEvento() {
            var x = document.getElementById("myDIV");
            if (x.style.display === "none") {
                x.style.display = "block";
                document.getElementById("exito-publicar").innerHTML = "Evento Publicado Exitosamente";
            } else {
                x.style.display = "none";
                document.getElementById("exito-publicar").innerHTML = "Evento Publicado Exitosamente";
            }
    }
    </script>
</body>

</html>