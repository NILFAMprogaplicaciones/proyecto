
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class DatosPrecargados implements IDatosPrecargados {
    ManejadorUsuario    MU=     ManejadorUsuario.getinstance(); 
    ManejadorCategoria  MC=     ManejadorCategoria.getinstance();
    ManejadorProducto   MP=     ManejadorProducto.getinstance();
    ManejadorPedido     MPP=    ManejadorPedido.getinstance();
    
    private static DatosPrecargados instancia = null;
    
    public static DatosPrecargados getinstance() {
        if (instancia == null) {
            instancia = new DatosPrecargados();
        }
        return instancia;
    }
   
    public void Clientes(){
        //CLIENTES
        Fecha fecha1=new Fecha(15,11,1983),fecha2=new Fecha(2,8,1975),fecha3=new Fecha(12,9,1987),fecha4=new Fecha(28,07,1951),fecha5=new Fecha(23,12,1978);
        File foto1 = new File("src/Imagenes/co.jpg"),foto2 = new File("src/Imagenes/ro.jpg"),foto3 = new File("src/Imagenes/usuario.png"),foto4 = new File("src/Imagenes/an.jpg"),foto5 = new File("src/Imagenes/we.jpg");
        
        
        DataCliente datacliente1=new DataCliente("costas123","Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1,"images/Usuarios/costas.png"); 
        Cliente cliente1=new Cliente(datacliente1);
        MU.addUsuario(cliente1.getnickname(), cliente1);
        
        DataCliente datacliente2=new DataCliente("12elroro","Rodrigo", "roro", "rcotelo@yahoo.com", "Av. Italia 2078","Costas", fecha2, foto2,"images/Usuarios/roro.png"); 
        Cliente cliente2=new Cliente(datacliente2);
        MU.addUsuario(cliente2.getnickname(), cliente2);
        
        DataCliente datacliente3=new DataCliente("ch4321","Cecilia", "chechi", "cgarrido@hotmail.com", "Gral. Urquiza 1548","Garrido", fecha3, foto3,"images/usuario.png"); 
        Cliente cliente3=new Cliente(datacliente3);
        MU.addUsuario(cliente3.getnickname(), cliente3);
        
        DataCliente datacliente4=new DataCliente("andy_la1","Andrea", "andy", "agarcia@gmail.com", "Dr. Manuel Albo 4512","García", fecha4, foto4,"images/Usuarios/andy.png"); 
        Cliente cliente4=new Cliente(datacliente4);
        MU.addUsuario(cliente4.getnickname(), cliente4);
        
        DataCliente datacliente5=new DataCliente("223_aweis","Adrian", "weiss", "aweiss@hotmail.com", "Monte Caseros 5615","Weiss", fecha5, foto5,"images/Usuarios/weiss.png"); 
        Cliente cliente5=new Cliente(datacliente5);
        MU.addUsuario(cliente5.getnickname(), cliente5);
        
        
    }
    public void Categorias(){
        
        Categoria cate1=new Categoria("Chivitos");
        MC.addCategoria(cate1.getnombre(), cate1);
        
        Categoria cate2=new Categoria("Minutas");
        MC.addCategoria(cate2.getnombre(), cate2);
        
        Categoria cate3=new Categoria("Parilla");
        MC.addCategoria(cate3.getnombre(), cate3);
        
        Categoria cate4=new Categoria("Pizzas");
        MC.addCategoria(cate4.getnombre(), cate4);
        
        Categoria cate5=new Categoria("Empanadas");
        MC.addCategoria(cate5.getnombre(), cate5);
        
        Categoria cate6=new Categoria("Milanesas");
        MC.addCategoria(cate6.getnombre(), cate6);
        
        Categoria cate7=new Categoria("Ensaladas");
        MC.addCategoria(cate7.getnombre(), cate7);
        
        Categoria cate8=new Categoria("Pastas");
        MC.addCategoria(cate8.getnombre(), cate8);
        
        Categoria cate9=new Categoria("Comida China");
        MC.addCategoria(cate9.getnombre(), cate9);
        
        Categoria cate10=new Categoria("Picadas");
        MC.addCategoria(cate10.getnombre(), cate10);
        
        Categoria cate11=new Categoria("Woks");
        MC.addCategoria(cate11.getnombre(), cate11);
        
        Categoria cate12=new Categoria("Comida Mexicana");
        MC.addCategoria(cate12.getnombre(), cate12);
        
        Categoria cate13=new Categoria("Entradas");
        MC.addCategoria(cate13.getnombre(), cate13);
        
        Categoria cate14=new Categoria("Bebidas");
        MC.addCategoria(cate14.getnombre(), cate14);
        
        Categoria cate15=new Categoria("Sushi");
        MC.addCategoria(cate15.getnombre(), cate15);
        
        
    }
    public void Restaurantes(){
        
        Map<String,Categoria> colcat1=new HashMap<String,Categoria>();
        colcat1.put("Chivitos", MC.getCategoria("Chivitos"));
        colcat1.put("Minutas", MC.getCategoria("Minutas"));
        colcat1.put("Parilla", MC.getCategoria("Parilla"));
        colcat1.put("Pizzas", MC.getCategoria("Pizzas"));
        Map<Integer,File> colfoto1=new HashMap<Integer,File>();
        File foto1 = new File("src/Imagenes/usuario.png"); 
        colfoto1.put(1, foto1);
        DataRestaurante dr1=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
        Restaurante res1=new Restaurante(dr1);
        MU.addUsuario(res1.getnickname(), res1);
        
        Map<String,Categoria> colcat2=new HashMap<String,Categoria>();
        colcat2.put("Chivitos", MC.getCategoria("Chivitos"));
        colcat2.put("Minutas", MC.getCategoria("Minutas"));
        colcat2.put("Pizzas", MC.getCategoria("Pizzas"));
        colcat2.put("Pastas", MC.getCategoria("Pastas"));
        Map<Integer,File> colfoto2=new HashMap<Integer,File>();
        File foto2 = new File("src/Imagenes/usuario.png"); 
        colfoto2.put(1, foto2);
        DataRestaurante dr2=new DataRestaurante("contraseña","Bar Rossell","rossell","bar.rossel@gmail.com","Bvar. Artigas 1601",colcat2,colfoto2);
        Restaurante res2=new Restaurante(dr2);
        MU.addUsuario(res2.getnickname(), res2);
        
        Map<String,Categoria> colcat3=new HashMap<String,Categoria>();
        colcat3.put("Empanadas", MC.getCategoria("Empanadas"));
        Map<Integer,File> colfoto3=new HashMap<Integer,File>();
        File foto3 = new File("src/Imagenes/usuario.png"); 
        colfoto3.put(1, foto3);
        DataRestaurante dr3=new DataRestaurante("contraseña","Empanadas Bocatti","bocatti","bocatti@gmail.com","18 de julio 2138",colcat3,colfoto3);
        Restaurante res3=new Restaurante(dr3);
        MU.addUsuario(res3.getnickname(), res3);
        
        Map<String,Categoria> colcat4=new HashMap<String,Categoria>();
        colcat4.put("Pastas", MC.getCategoria("Pastas"));
        colcat4.put("Comida China", MC.getCategoria("Comida China"));
        colcat4.put("Woks", MC.getCategoria("Woks"));
        Map<Integer,File> colfoto4=new HashMap<Integer,File>();
        File foto4 = new File("src/Imagenes/wb.jpg"); 
        colfoto4.put(1, foto4);
        DataRestaurante dr4=new DataRestaurante("contraseña","Wok in Box","winb","wok.in.box@hotmail.com","Libertad 2535",colcat4,colfoto4);
        Restaurante res4=new Restaurante(dr4);
        MU.addUsuario(res4.getnickname(), res4);
    }
    public void ProductosIndividuales(){
        
        Restaurante pm=MU.findRestaurante("mera"),br=MU.findRestaurante("rossell"),eb=MU.findRestaurante("bocatti"),wb=MU.findRestaurante("winb");
        File foto1=new File("src/Imagenes/producto.jpg"),mcm=new File("src/Imagenes/mcm.jpg"),ccm=new File("src/Imagenes/ccm.jpg"),
                mcr=new File("src/Imagenes/mcr.jpg"),ecb=new File("src/Imagenes/ecb.jpg"),eqb=new File("src/Imagenes/eqb.jpg"),
                eca=new File("src/Imagenes/eca.jpg"),tww=new File("src/Imagenes/tww.jpg"),cpw=new File("src/Imagenes/cpw.jpg");
        
        DataIndividual di1=new DataIndividual( "Asado", "Asado a la parrilla", pm, 225, foto1,"images/Productos/Asado.png");
        Individual i1=new Individual(di1);
        MP.addProductoIndividual(i1);
        MU.addProductoIndividual(di1.getRestaurante().getnickname(),i1);
        
        DataIndividual di2=new DataIndividual( "Milanesa de Carne", "Con lechuga, tomate, mayonesa y fritas", pm, 180, mcm,"images/Productos/Milanesa de Carne.png");
        Individual i2=new Individual(di2);
        MP.addProductoIndividual(i2);
        MU.addProductoIndividual(di2.getRestaurante().getnickname(),i2);
        
        DataIndividual di3=new DataIndividual( "Chivito canadiense", "Lomito, jamón, muzza, tomate, aceitunas, panceta, huevo, morrón y fritas", pm, 305, ccm,"images/Productos/Chivito canadiense.png");
        Individual i3=new Individual(di3);
        MP.addProductoIndividual(i3);
        MU.addProductoIndividual(di3.getRestaurante().getnickname(),i3);
        
        DataIndividual di4=new DataIndividual( "Pizza 2 gustos", "Pizza con dos gustos a elección", pm, 130, foto1,"images/Productos/Pizza 2 gustos.png");
        Individual i4=new Individual(di4);
        MP.addProductoIndividual(i4);
        MU.addProductoIndividual(di4.getRestaurante().getnickname(),i4);
        
        DataIndividual di5=new DataIndividual( "Chivito al plato", "Ensalada rusa, mixta, huevo, jamón, muzza, panceta, aceitunas y fritas", br, 324, foto1,"images/Productos/Chivito al plato.png");
        Individual i5=new Individual(di5);
        MP.addProductoIndividual(i5);
        MU.addProductoIndividual(di5.getRestaurante().getnickname(),i5);
        
        DataIndividual di6=new DataIndividual( "Milanesa a caballo", "Milanesa con dos huevos fritos acompañado de fritas", br, 270, mcr,"images/Productos/Milanesa a caballo.png");
        Individual i6=new Individual(di6);
        MP.addProductoIndividual(i6);
        MU.addProductoIndividual(di6.getRestaurante().getnickname(),i6);
        
        DataIndividual di7=new DataIndividual( "Pizza con 2 gustos", "Pizza con dos gustos a elección", br, 103, foto1,"images/Productos/Pizza con 2 gustos.png");
        Individual i7=new Individual(di7);
        MP.addProductoIndividual(i7);
        MU.addProductoIndividual(di7.getRestaurante().getnickname(),i7);
        
        DataIndividual di8=new DataIndividual( "Agnolotis", "Agnolotis de jamón y queso", br, 225, foto1,"images/Productos/Agnolotis.png");
        Individual i8=new Individual(di8);
        MP.addProductoIndividual(i8);
        MU.addProductoIndividual(di8.getRestaurante().getnickname(),i8);
        
        DataIndividual di9=new DataIndividual( "Empanada de Carne", "Carne, aceitunas, huevo duro, condimentos", eb, 44, ecb,"images/Productos/Empanada de Carne.png");
        Individual i9=new Individual(di9);
        MP.addProductoIndividual(i9);
        MU.addProductoIndividual(di9.getRestaurante().getnickname(),i9);
        
        DataIndividual di10=new DataIndividual( "Empanada Americana", "Carne, panceta y huevo duro", eb, 44, foto1,"images/Productos/Empanada Americana.png");
        Individual i10=new Individual(di10);
        MP.addProductoIndividual(i10);
        MU.addProductoIndividual(di10.getRestaurante().getnickname(),i10);
        
        DataIndividual di11=new DataIndividual( "Empanada QyC", "Empanada de Queso y Cebolla", eb, 44, eqb,"images/Productos/Empanada QyC.png");
        Individual i11=new Individual(di11);
        MP.addProductoIndividual(i11);
        MU.addProductoIndividual(di11.getRestaurante().getnickname(),i11);
        
        DataIndividual di12=new DataIndividual( "Empanada Capresse", "Queso, tomate y albahaca", eb, 44, eca,"images/Productos/Empanada Capresse.png");
        Individual i12=new Individual(di12);
        MP.addProductoIndividual(i12);
        MU.addProductoIndividual(di12.getRestaurante().getnickname(),i12);
        
        DataIndividual di13=new DataIndividual( "Thai wok", "Cerdo, calamares, sweet chili, salsa de ostras, maní y jugo de lima, acompañado de tallarines o arroz.", wb, 240, tww,"images/Productos/Thai wok.png");
        Individual i13=new Individual(di13);
        MP.addProductoIndividual(i13);
        MU.addProductoIndividual(di13.getRestaurante().getnickname(),i13);
        
        DataIndividual di14=new DataIndividual( "China wok", "Tempura de cerdo, vegetales mixtos, almendras, salsa de soja y naranja, acompañado de tallarines o arroz.", wb, 240, foto1,"images/Productos/China wok.png");
        Individual i14=new Individual(di14);
        MP.addProductoIndividual(i14);
        MU.addProductoIndividual(di14.getRestaurante().getnickname(),i14);
        
        DataIndividual di15=new DataIndividual( "Classic wok de pollo", "Pollo, vegetales mixtos, salsa agridulce, salsa de soja y cebollita de verdeo, acompañado de tallarines o arroz.", wb, 230, cpw,"images/Productos/Classic wok de pollo.png");
        Individual i15=new Individual(di15);
        MP.addProductoIndividual(i15);
        MU.addProductoIndividual(di15.getRestaurante().getnickname(),i15);
        
        DataIndividual di16=new DataIndividual( "Classic wok de cerdo", "Cerdo, vegetales mixtos, jengibre, salsa de ostras y ralladura de lima, acompañado de tallarines o arroz.", wb, 230, foto1,"images/Productos/Classic wok de cerdo.png");
        Individual i16=new Individual(di16);
        MP.addProductoIndividual(i16);
        MU.addProductoIndividual(di16.getRestaurante().getnickname(),i16);
    }
    public void ProductosPromociones(){
        Restaurante pm=MU.findRestaurante("mera"),br=MU.findRestaurante("rossell");
        File foto=new File("src/Imagenes/producto.jpg");
        
        Map<String,DataCantidad> col1=new HashMap<String,DataCantidad>();
        Producto producto1=MU.getProductoRestaurante(pm.getnickname(), "Chivito canadiense");
        Producto producto2=MU.getProductoRestaurante(pm.getnickname(), "Pizza 2 gustos");
        DataCantidad datacan1=new DataCantidad(1,producto1);
        DataCantidad datacan2=new DataCantidad(1, producto2);
        col1.put(datacan1.getProducto().getnombre(), datacan1);
        col1.put(datacan2.getProducto().getnombre(), datacan2);
        DataPromocion datapromo1=new DataPromocion(pm,"ChiviPizza", "Chivito y Pizza" , 348,  true, 20 , col1,foto,"images/Productos/ChiviPizza.png");
        Promocion promo1=new Promocion(datapromo1);
        MP.addProductoPromocion(promo1);
        MU.addProductoPromocion(promo1.getRestaurante().getnickname(),promo1);
        
        Map<String,DataCantidad> col2=new HashMap<String,DataCantidad>();
        Producto producto3=MU.getProductoRestaurante(pm.getnickname(), "Milanesa de Carne");
        Producto producto4=MU.getProductoRestaurante(pm.getnickname(), "Asado");
        DataCantidad datacan3=new DataCantidad(3,producto3);
        DataCantidad datacan4=new DataCantidad(1, producto4);
        col2.put(datacan3.getProducto().getnombre(), datacan3);
        col2.put(datacan4.getProducto().getnombre(), datacan4);
        DataPromocion datapromo2=new DataPromocion(pm,"MilaAsado", "3 Milanesas + 1 Asado para compartir" , 535.5,  true, 30 , col2,foto,"images/Productos/MilaAsado.png");
        Promocion promo2=new Promocion(datapromo2);
        MP.addProductoPromocion(promo2);
        MU.addProductoPromocion(promo2.getRestaurante().getnickname(),promo2);
        
        Map<String,DataCantidad> col3=new HashMap<String,DataCantidad>();
        Producto producto5=MU.getProductoRestaurante(br.getnickname(), "Milanesa a caballo");
        Producto producto6=MU.getProductoRestaurante(br.getnickname(), "Pizza con 2 gustos");
        DataCantidad datacan5=new DataCantidad(2,producto5);
        DataCantidad datacan6=new DataCantidad(1, producto6);
        col3.put(datacan5.getProducto().getnombre(), datacan5);
        col3.put(datacan6.getProducto().getnombre(), datacan6);
        DataPromocion datapromo3=new DataPromocion(br,"MilaPizza", "2 Milanesas a caballo + 1 Pizzas 2 gustos" , 578.7,  true, 10 , col3,foto,"images/Productos/MilaPizza.png");
        Promocion promo3=new Promocion(datapromo3);
        MP.addProductoPromocion(promo3);
        MU.addProductoPromocion(promo3.getRestaurante().getnickname(),promo3);
    }
    public void Pedidos(){
        FechaHora fecha1=new FechaHora(12,8,2015,0,0),fecha2=new FechaHora(19,8,2015,0,0),fecha3=new FechaHora(19,8,2015,0,0),
                fecha4=new FechaHora(22,8,2015,0,0),fecha5=new FechaHora(25,8,2015,0,0);
        Cliente co=MU.findCliente("costas"),ro=MU.findCliente("roro"),ch=MU.findCliente("chechi"),an=MU.findCliente("andy"),we=MU.findCliente("weiss");
        Producto ecb=MP.findProducto("Empanada de Carne"), eab=MP.findProducto("Empanada Americana"), eqb=MP.findProducto("Empanada QyC"),
                asm=MP.findProducto("Asado"), tww=MP.findProducto("Thai wok"), cww=MP.findProducto("China wok"), ccm=MP.findProducto("Chivito canadiense"), par=MP.findProducto("Agnolotis");
        Restaurante eb=MU.findRestaurante("bocatti"),pm=MU.findRestaurante("mera"),wb=MU.findRestaurante("winb"),br=MU.findRestaurante("rossell");
        
        
        Map<String,Producto> col1=new HashMap<String,Producto>();
        col1.put(ecb.getnombre(),ecb);
        col1.put(eab.getnombre(), eab);
        col1.put(eqb.getnombre(), eqb);
        Map<String,DataProductosPedido> colpp1=new HashMap<String,DataProductosPedido>();
        DataProductosPedido dpp1=new DataProductosPedido(ecb, 1,44),dpp2=new DataProductosPedido(eab, 2,88),dpp3=new DataProductosPedido(eqb, 2,88);
        colpp1.put(dpp1.getProducto().getnombre(), dpp1);
        colpp1.put(dpp2.getProducto().getnombre(), dpp2);
        colpp1.put(dpp3.getProducto().getnombre(), dpp3);
        TipoAsosiativoPedido tap1=new TipoAsosiativoPedido(colpp1);
        DataPedido datapedido1=new DataPedido(1, fecha1, 220, Estado.PREPARCION, co, col1,  eb, tap1);
        Pedido pedido1=new Pedido(datapedido1);
        MPP.addPedido(pedido1.getnum(), pedido1);
        
        Map<String,Producto> col2=new HashMap<String,Producto>();
        col2.put(asm.getnombre(),asm);
        Map<String,DataProductosPedido> colpp2=new HashMap<String,DataProductosPedido>();
        DataProductosPedido dpp4=new DataProductosPedido(asm, 3,675);
        colpp2.put(dpp4.getProducto().getnombre(), dpp4);
        TipoAsosiativoPedido tap2=new TipoAsosiativoPedido(colpp2);
        DataPedido datapedido2=new DataPedido(2, fecha2, 675, Estado.ENVIADO, ro, col2,  pm, tap2);
        Pedido pedido2=new Pedido(datapedido2);
        MPP.addPedido(pedido2.getnum(), pedido2);
        
        Map<String,Producto> col3=new HashMap<String,Producto>();
        col3.put(tww.getnombre(),tww);
        col3.put(cww.getnombre(),cww);
        Map<String,DataProductosPedido> colpp3=new HashMap<String,DataProductosPedido>();
        DataProductosPedido dpp5=new DataProductosPedido(tww, 2,480),dpp6=new DataProductosPedido(cww, 3,720);
        colpp3.put(dpp5.getProducto().getnombre(), dpp5);
        colpp3.put(dpp6.getProducto().getnombre(), dpp6);
        TipoAsosiativoPedido tap3=new TipoAsosiativoPedido(colpp3);
        DataPedido datapedido3=new DataPedido(3, fecha3, 1200, Estado.RECIBIDO, ch, col3,  wb, tap3);
        Pedido pedido3=new Pedido(datapedido3);
        MPP.addPedido(pedido3.getnum(), pedido3);
        
        Map<String,Producto> col4=new HashMap<String,Producto>();
        col4.put(ccm.getnombre(),ccm);
        Map<String,DataProductosPedido> colpp4=new HashMap<String,DataProductosPedido>();
        DataProductosPedido dpp7=new DataProductosPedido(ccm, 4,1220);
        colpp4.put(dpp7.getProducto().getnombre(), dpp7);
        TipoAsosiativoPedido tap4=new TipoAsosiativoPedido(colpp4);
        DataPedido datapedido4=new DataPedido(4, fecha4, 1220, Estado.RECIBIDO, an, col4,  pm, tap4);
        Pedido pedido4=new Pedido(datapedido4);
        MPP.addPedido(pedido4.getnum(), pedido4);
        
        Map<String,Producto> col5=new HashMap<String,Producto>();
        col5.put(par.getnombre(),par);
        Map<String,DataProductosPedido> colpp5=new HashMap<String,DataProductosPedido>();
        DataProductosPedido dpp8=new DataProductosPedido(par, 1,225);
        colpp5.put(dpp8.getProducto().getnombre(), dpp8);
        TipoAsosiativoPedido tap5=new TipoAsosiativoPedido(colpp5);
        DataPedido datapedido5=new DataPedido(5, fecha5, 225, Estado.RECIBIDO, we, col5,  br, tap5);
        Pedido pedido5=new Pedido(datapedido5);
        MPP.addPedido(pedido5.getnum(), pedido5);
        
    }
    
    @Override
    public void DatosPrecargado(){
        Clientes();
        Categorias();
        Restaurantes();
        ProductosIndividuales();
        ProductosPromociones();
        Pedidos();
        
        
    } 
}
