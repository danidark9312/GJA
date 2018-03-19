        <div class="menu-top">    
        
            <div class="row bg-menu">
            
                <nav class="navbar navbar-static-top" role="navigation">

                    <div class="container">

                        <div class="navbar-header">
                            <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                                <i class="fa fa-reorder"></i>
                            </button>
                            <a href="#" class="navbar-brand" style="padding-top: 0%;">
                                <img src="img/logo-header.png" class="logo-desktop">
                              
                            </a>
                        </div>
                        
                        <div class="navbar-collapse collapse" id="navbar">
                            
                            <ul class="nav navbar-nav">
							
                              	<li class="dropdown"><a aria-expanded="false" role="button" class="dropdown-toggle"
									href="visorCaso" style="color: #ffffff"> <spring:message
											code="label.menu.title.inicio" /></a>
											</li>
                              	<li class="dropdown"><a aria-expanded="false" role="button"
									href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: #ffffff"><spring:message
											code="label.menu.title.casos" /><span class="caret"></span></a>
									<ul role="menu" class="dropdown-menu">
<!-- 										<li><a href="formularioRadicado">Nuevo Radicado</a></li> -->
										<li><a href="visorCaso">Visor de Casos</a></li>
									</ul></li>
							<sec:authorize access="hasAnyRole('ROLE_SUPER_USER','ROLE_ADMIN')">	
								<li class="dropdown"><a aria-expanded="false" role="button"
									href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: #ffffff"> Administradores <span class="caret"></span></a>
									<ul role="menu" class="dropdown-menu">
										<li><a href="maestroActividad">Actividades</a></li>
										<li><a href="maestroTipoCaso">Tipos casos</a></li>
									</ul></li>	
								</sec:authorize>	
                            </ul>

                        </div>    

                    </div>
                </nav>
            </div>

        </div>    