<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   
   <style>
   	body > nav.navbar.border-bottom.navbar-menu {
   		border-bottom: none !important;
   	}
   </style>
 <div class="border-bottom pb-lg-4 pb-3">
        <nav class="navbar navbar-expand-lg navbar-light navbar-default pt-0 pb-0">
            <div class="container px-0 px-md-3">

                <div class="dropdown me-3 d-none d-lg-block">
                    <button class="btn btn-primary px-6 " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        <span class="me-1">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-grid">
                                <rect x="3" y="3" width="7" height="7"></rect>
                                <rect x="14" y="3" width="7" height="7"></rect>
                                <rect x="14" y="14" width="7" height="7"></rect>
                                <rect x="3" y="14" width="7" height="7"></rect>
                            </svg></span> All Departments
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="./pages/shop-grid.html">Dairy, Bread &amp; Eggs</a></li>
                        <li><a class="dropdown-item" href="./pages/shop-grid.html">Snacks &amp; Munchies</a></li>
                        <li><a class="dropdown-item" href="./pages/shop-grid.html">Fruits &amp; Vegetables</a></li>
                        <li><a class="dropdown-item" href="./pages/shop-grid.html">Cold Drinks &amp; Juices</a></li>
                        <li><a class="dropdown-item" href="./pages/shop-grid.html">Breakfast &amp; Instant Food</a></li>
                        <li><a class="dropdown-item" href="./pages/shop-grid.html">Bakery &amp; Biscuits</a></li>

                        <li><a class="dropdown-item" href="./pages/shop-grid.html">Chicken, Meat &amp; Fish</a></li>
                    </ul>
                </div>



                <div class="offcanvas offcanvas-start p-4 p-lg-0" id="navbar-default">

                    <div class="d-flex justify-content-between align-items-center mb-2 d-block d-lg-none">
                        <a href="./index.html"><img src="/PhoneCartShop/Assets/assets/images/logo/freshcart-logo.svg" alt="eCommerce HTML Template"></a>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>

                    <div class="d-block d-lg-none mb-2 pt-2">
                        <a class="btn btn-primary w-100 d-flex justify-content-center align-items-center" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                            <span class="me-2"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="feather feather-grid">
                                    <rect x="3" y="3" width="7" height="7"></rect>
                                    <rect x="14" y="3" width="7" height="7"></rect>
                                    <rect x="14" y="14" width="7" height="7"></rect>
                                    <rect x="3" y="14" width="7" height="7"></rect>
                                </svg></span> All Departments
                        </a>
                        <div class="collapse mt-2" id="collapseExample">
                            <div class="card card-body">
                                <ul class="mb-0 list-unstyled">
                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Dairy, Bread &amp; Eggs</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Snacks &amp; Munchies</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Fruits &amp; Vegetables</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Cold Drinks &amp; Juices</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Breakfast &amp; Instant
                                            Food</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Bakery &amp; Biscuits</a>
                                    </li>

                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Chicken, Meat &amp; Fish</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="d-lg-none d-block mb-3">
                        <button type="button" class="btn  btn-outline-gray-400 text-muted w-100 " data-bs-toggle="modal" data-bs-target="#locationModal">
                            <i class="feather-icon icon-map-pin me-2"></i>Pick Location
                        </button>
                    </div>
                    <div class="d-none d-lg-block">
                        <ul class="navbar-nav ">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Home
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./index.html">Home 1</a></li>
                                    <li><a class="dropdown-item" href="./pages/index-2.html">Home 2</a></li>
                                    <li><a class="dropdown-item" href="./pages/index-3.html">Home 3</a></li>

                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Shop
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Shop Grid - Filter</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-grid-3-column.html">Shop Grid - 3
                                            column</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-list.html">Shop List - Filter</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-filter.html">Shop - Filter</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-fullwidth.html">Shop Wide</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-single.html">Shop Single</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-wishlist.html">Shop Wishlist</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-cart.html">Shop Cart</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-checkout.html">Shop Checkout</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Stores
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./pages/store-list.html">Store List</a></li>
                                    <li><a class="dropdown-item" href="./pages/store-grid.html">Store Grid</a></li>
                                    <li><a class="dropdown-item" href="./pages/store-single.html">Store Single</a></li>

                                </ul>
                            </li>

                            <li class="nav-item dropdown dropdown-fullwidth">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Mega menu
                                </a>
                                <div class=" dropdown-menu pb-0">

                                    <div class="row p-2 p-lg-4">
                                        <div class="col-lg-3 col-6 mb-4 mb-lg-0">
                                            <h6 class="text-primary ps-3">Dairy, Bread &amp; Eggs</h6>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Butter</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Milk Drinks</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Curd &amp; Yogurt</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Eggs</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Buns &amp; Bakery</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Cheese</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Condensed Milk</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Dairy Products</a>

                                        </div>
                                        <div class="col-lg-3 col-6 mb-4 mb-lg-0">
                                            <h6 class="text-primary ps-3">Breakfast &amp; Instant Food</h6>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Breakfast Cereal</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html"> Noodles, Pasta &amp;
                                                Soup</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Frozen Veg Snacks</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html"> Frozen Non-Veg
                                                Snacks</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html"> Vermicelli</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html"> Instant Mixes</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html"> Batter</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html"> Fruit and Juices</a>

                                        </div>
                                        <div class="col-lg-3 col-12 mb-4 mb-lg-0">
                                            <h6 class="text-primary ps-3">Cold Drinks &amp; Juices</h6>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Soft Drinks</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Fruit Juices</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Coldpress</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Water &amp; Ice Cubes</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Soda &amp; Mixers</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Health Drinks</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Herbal Drinks</a>
                                            <a class="dropdown-item" href="./pages/shop-grid.html">Milk Drinks</a>


                                        </div>
                                        <div class="col-lg-3 col-12 mb-4 mb-lg-0">
                                            <div class="card border-0">
                                                <img src="/PhoneCartShop/Assets/assets/images/banner/menu-banner.jpg" alt="eCommerce HTML Template" class="img-fluid rounded-3">
                                                <div class="position-absolute ps-6 mt-8">
                                                    <h5 class=" mb-0 ">Dont miss this <br>offer today.</h5>
                                                    <a href="#" class="btn btn-primary btn-sm mt-3">Shop Now</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Pages
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./pages/blog.html">Blog</a></li>
                                    <li><a class="dropdown-item" href="./pages/blog-single.html">Blog Single</a></li>
                                    <li><a class="dropdown-item" href="./pages/blog-category.html">Blog Category</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/about.html">About us</a></li>
                                    <li><a class="dropdown-item" href="./pages/404error.html">404 Error</a></li>
                                    <li><a class="dropdown-item" href="./pages/contact.html">Contact</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Account
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./pages/signin.html">Sign in</a></li>
                                    <li><a class="dropdown-item" href="./pages/signup.html">Signup</a></li>
                                    <li><a class="dropdown-item" href="./pages/forgot-password.html">Forgot Password</a>
                                    </li>
                                    <li class="dropdown-submenu dropend">
                                        <a class="dropdown-item dropdown-list-group-item dropdown-toggle" href="#">
                                            My Account
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item" href="./pages/account-orders.html">Orders</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/account-settings.html">Settings</a></li>
                                            <li><a class="dropdown-item" href="./pages/account-address.html">Address</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/account-payment-method.html">Payment Method</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/account-notification.html">Notification</a></li>


                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="./docs/index.html">
                                    Docs
                                </a>

                            </li>
                        </ul>
                    </div>
                    <div class="d-block d-lg-none">
                        <ul class="navbar-nav ">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Home
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./index.html">Home 1</a></li>
                                    <li><a class="dropdown-item" href="./pages/index-2.html">Home 2</a></li>
                                    <li><a class="dropdown-item" href="./pages/index-3.html">Home 3</a></li>

                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Shop
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./pages/shop-grid.html">Shop Grid - Filter</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-grid-3-column.html">Shop Grid - 3
                                            column</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-list.html">Shop List - Filter</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-filter.html">Shop - Filter</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-fullwidth.html">Shop Wide</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-single.html">Shop Single</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-wishlist.html">Shop Wishlist</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/shop-cart.html">Shop Cart</a></li>
                                    <li><a class="dropdown-item" href="./pages/shop-checkout.html">Shop Checkout</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Stores
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./pages/store-list.html">Store List</a></li>
                                    <li><a class="dropdown-item" href="./pages/store-grid.html">Store Grid</a></li>
                                    <li><a class="dropdown-item" href="./pages/store-single.html">Store Single</a></li>

                                </ul>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Mega Menu
                                </a>
                                <ul class="dropdown-menu">

                                    <li class="dropdown-submenu ">
                                        <a class="dropdown-item dropdown-list-group-item dropdown-toggle" href="#">
                                            Dairy, Bread &amp; Eggs
                                        </a>
                                        <ul class="dropdown-menu">


                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Milk Drinks</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Curd &amp; Yogurt</a>
                                            </li>
                                            <li> <a class="dropdown-item" href="./pages/shop-grid.html">Eggs</a></li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Buns &amp; Bakery</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Cheese</a></li>
                                            <li> <a class="dropdown-item" href="./pages/shop-grid.html">Condensed
                                                    Milk</a></li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Dairy
                                                    Products</a></li>


                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu ">
                                        <a class="dropdown-item dropdown-list-group-item dropdown-toggle" href="#">
                                            Vegetables &amp; Fruits
                                        </a>
                                        <ul class="dropdown-menu">


                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Vegetables</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Fruits</a></li>
                                            <li> <a class="dropdown-item" href="./pages/shop-grid.html">Exotics &amp;
                                                    Premium</a></li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Fresh Sprouts</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Frozen Veg</a>
                                            </li>



                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu ">
                                        <a class="dropdown-item dropdown-list-group-item dropdown-toggle" href="#">
                                            Cold Drinks &amp; Juices
                                        </a>
                                        <ul class="dropdown-menu">


                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Soft Drinks</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Fruit Juices</a>
                                            </li>
                                            <li> <a class="dropdown-item" href="./pages/shop-grid.html">Coldpress</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Soda &amp; Mixers</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Milk Drinks</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Health Drinks</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/shop-grid.html">Herbal Drinks</a>
                                            </li>



                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Pages
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./pages/blog.html">Blog</a></li>
                                    <li><a class="dropdown-item" href="./pages/blog-single.html">Blog Single</a></li>
                                    <li><a class="dropdown-item" href="./pages/blog-category.html">Blog Category</a>
                                    </li>
                                    <li><a class="dropdown-item" href="./pages/about.html">About us</a></li>
                                    <li><a class="dropdown-item" href="./pages/404error.html">404 Error</a></li>
                                    <li><a class="dropdown-item" href="./pages/contact.html">Contact</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Account
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./pages/signin.html">Sign in</a></li>
                                    <li><a class="dropdown-item" href="./pages/signup.html">Signup</a></li>
                                    <li><a class="dropdown-item" href="./pages/forgot-password.html">Forgot Password</a>
                                    </li>
                                    <li class="dropdown-submenu dropend">
                                        <a class="dropdown-item dropdown-list-group-item dropdown-toggle" href="#">
                                            My Account
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item" href="./pages/account-orders.html">Orders</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/account-settings.html">Settings</a></li>
                                            <li><a class="dropdown-item" href="./pages/account-address.html">Address</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/account-payment-method.html">Payment Method</a>
                                            </li>
                                            <li><a class="dropdown-item" href="./pages/account-notification.html">Notification</a></li>


                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="./docs/index.html">
                                    Docs
                                </a>

                            </li>
                        </ul>
                    </div>


                </div>
            </div>

        </nav>
    </div>