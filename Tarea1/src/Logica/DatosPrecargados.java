
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


public class DatosPrecargados {
    ManejadorUsuario    MU= ManejadorUsuario.getinstance(); 
    ManejadorCategoria  MC= ManejadorCategoria.getinstance();
    ManejadorProducto   MP= ManejadorProducto.getinstance();
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
        
        DataCliente datacliente1=new DataCliente("Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1); 
        Cliente cliente1=new Cliente(datacliente1);
        MU.addUsuario(cliente1.getnickname(), cliente1);
        
        DataCliente datacliente2=new DataCliente("Rodrigo", "roro", "rcotelo@yahoo.com", "Av. Italia 2078","Costas", fecha2, foto2); 
        Cliente cliente2=new Cliente(datacliente2);
        MU.addUsuario(cliente2.getnickname(), cliente2);
        
        DataCliente datacliente3=new DataCliente("Cecilia", "chechi", "cgarrido@hotmail.com", "Gral. Urquiza 1548","Garrido", fecha3, foto3); 
        Cliente cliente3=new Cliente(datacliente3);
        MU.addUsuario(cliente3.getnickname(), cliente3);
        
        DataCliente datacliente4=new DataCliente("Andrea", "andy", "agarcia@gmail.com", "Dr. Manuel Albo 4512","García", fecha4, foto4); 
        Cliente cliente4=new Cliente(datacliente4);
        MU.addUsuario(cliente4.getnickname(), cliente4);
        
        DataCliente datacliente5=new DataCliente("Adrian", "weiss", "aweiss@hotmail.com", "Monte Caseros 5615","Weiss", fecha5, foto5); 
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
        DataRestaurante dr1=new DataRestaurante("Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
        Restaurante res1=new Restaurante(dr1);
        MU.addUsuario(res1.getnickname(), res1);
        
        Map<String,Categoria> colcat2=new HashMap<String,Categoria>();
        colcat2.put("Chivitos", MC.getCategoria("Chivitos"));
        colcat2.put("Minutas", MC.getCategoria("Minutas"));
        colcat2.put("Pizzas", MC.getCategoria("Pizzas"));
        colcat2.put("Pastas", MC.getCategoria("Pastas"));
        Map<Integer,File> colfoto2=new HashMap<Integer,File>();
        File foto2 = new File("src/Imagenes/usuario.png"); 
        colfoto2.put(2, foto2);
        DataRestaurante dr2=new DataRestaurante("Bar Rossell","rossell","bar.rossel@gmail.com","Bvar. Artigas 1601",colcat2,colfoto2);
        Restaurante res2=new Restaurante(dr2);
        MU.addUsuario(res2.getnickname(), res2);
        
        Map<String,Categoria> colcat3=new HashMap<String,Categoria>();
        colcat3.put("Empanadas", MC.getCategoria("Empanadas"));
        Map<Integer,File> colfoto3=new HashMap<Integer,File>();
        File foto3 = new File("src/Imagenes/usuario.png"); 
        colfoto3.put(3, foto3);
        DataRestaurante dr3=new DataRestaurante("Empanadas Bocatti","bocatti","bocatti@gmail.com","18 de julio 2138",colcat3,colfoto3);
        Restaurante res3=new Restaurante(dr3);
        MU.addUsuario(res3.getnickname(), res3);
        
        Map<String,Categoria> colcat4=new HashMap<String,Categoria>();
        colcat4.put("Pastas", MC.getCategoria("Pastas"));
        colcat4.put("Comida China", MC.getCategoria("Comida China"));
        colcat4.put("Woks", MC.getCategoria("Woks"));
        Map<Integer,File> colfoto4=new HashMap<Integer,File>();
        File foto4 = new File("src/Imagenes/wb.png"); 
        colfoto4.put(4, foto4);
        DataRestaurante dr4=new DataRestaurante("Wok in Box","winb","wok.in.box@hotmail.com","Libertad 2535",colcat4,colfoto4);
        Restaurante res4=new Restaurante(dr4);
        MU.addUsuario(res4.getnickname(), res4);
    }
    public void ProductosIndividuales(){
        
        Restaurante pm=MU.findRestaurante("mera"),br=MU.findRestaurante("rossell"),eb=MU.findRestaurante("bocatti"),wb=MU.findRestaurante("winb");
        File foto1=new File("src/Imagenes/producto.jpg"),mcm=new File("src/Imagenes/mcm.jpg"),ccm=new File("src/Imagenes/ccm.jpg"),
                mcr=new File("src/Imagenes/mcr.jpg"),ecb=new File("src/Imagenes/ecb.jpg"),eqb=new File("src/Imagenes/eqb.jpg"),
                eca=new File("src/Imagenes/eca.jpg"),tww=new File("src/Imagenes/tww.jpg"),cpw=new File("src/Imagenes/cpw.jpg");
        
        DataIndividual di1=new DataIndividual( "Asado", "Asado a la parrilla", pm, 225, foto1);
        Individual i1=new Individual(di1);
        MP.addProductoIndividual(di1.getNombre(),i1);
        MU.addProductoIndividual(di1.getRestaurante().getnickname(),i1);
        
        DataIndividual di2=new DataIndividual( "Milanesa de Carne", "Con lechuga, tomate, mayonesa y fritas", pm, 180, mcm);
        Individual i2=new Individual(di2);
        MP.addProductoIndividual(di2.getNombre(),i2);
        MU.addProductoIndividual(di2.getRestaurante().getnickname(),i2);
        
        DataIndividual di3=new DataIndividual( "Chivito canadiense", "Lomito, jamón, muzza, tomate, aceitunas, panceta, huevo, morrón y fritas", pm, 305, ccm);
        Individual i3=new Individual(di3);
        MP.addProductoIndividual(di3.getNombre(),i3);
        MU.addProductoIndividual(di3.getRestaurante().getnickname(),i3);
        
        DataIndividual di4=new DataIndividual( "Pizza 2 gustos", "Pizza con dos gustos a elección", pm, 130, foto1);
        Individual i4=new Individual(di4);
        MP.addProductoIndividual(di4.getNombre(),i4);
        MU.addProductoIndividual(di4.getRestaurante().getnickname(),i4);
        
        DataIndividual di5=new DataIndividual( "Chivito al plato", "Ensalada rusa, mixta, huevo, jamón, muzza, panceta, aceitunas y fritas", br, 324, foto1);
        Individual i5=new Individual(di5);
        MP.addProductoIndividual(di5.getNombre(),i5);
        MU.addProductoIndividual(di5.getRestaurante().getnickname(),i5);
        
        DataIndividual di6=new DataIndividual( "Milanesa a caballo", "Milanesa con dos huevos fritos acompañado de fritas", br, 270, mcr);
        Individual i6=new Individual(di6);
        MP.addProductoIndividual(di6.getNombre(),i6);
        MU.addProductoIndividual(di6.getRestaurante().getnickname(),i6);
        
        DataIndividual di7=new DataIndividual( "Pizza con 2 gustos", "Pizza con dos gustos a elección", br, 103, foto1);
        Individual i7=new Individual(di7);
        MP.addProductoIndividual(di7.getNombre(),i7);
        MU.addProductoIndividual(di7.getRestaurante().getnickname(),i7);
        
        DataIndividual di8=new DataIndividual( "Agnolotis", "Agnolotis de jamón y queso", br, 225, foto1);
        Individual i8=new Individual(di8);
        MP.addProductoIndividual(di8.getNombre(),i8);
        MU.addProductoIndividual(di8.getRestaurante().getnickname(),i8);
        
        DataIndividual di9=new DataIndividual( "Empanada de Carne", "Carne, aceitunas, huevo duro, condimentos", eb, 44, ecb);
        Individual i9=new Individual(di9);
        MP.addProductoIndividual(di9.getNombre(),i9);
        MU.addProductoIndividual(di9.getRestaurante().getnickname(),i9);
        
        DataIndividual di10=new DataIndividual( "Empanada Americana", "Carne, panceta y huevo duro", eb, 44, foto1);
        Individual i10=new Individual(di10);
        MP.addProductoIndividual(di10.getNombre(),i10);
        MU.addProductoIndividual(di10.getRestaurante().getnickname(),i10);
        
        DataIndividual di11=new DataIndividual( "Empanada QyC", "Empanada de Queso y Cebolla", eb, 44, eqb);
        Individual i11=new Individual(di11);
        MP.addProductoIndividual(di11.getNombre(),i11);
        MU.addProductoIndividual(di11.getRestaurante().getnickname(),i11);
        
        DataIndividual di12=new DataIndividual( "Empanada Capresse", "Queso, tomate y albahaca", eb, 44, eca);
        Individual i12=new Individual(di12);
        MP.addProductoIndividual(di12.getNombre(),i12);
        MU.addProductoIndividual(di12.getRestaurante().getnickname(),i12);
        
        DataIndividual di13=new DataIndividual( "Thai wok", "Cerdo, calamares, sweet chili, salsa de ostras, maní y jugo de lima, acompañado de tallarines o arroz.", wb, 240, tww);
        Individual i13=new Individual(di13);
        MP.addProductoIndividual(di13.getNombre(),i13);
        MU.addProductoIndividual(di13.getRestaurante().getnickname(),i13);
        
        DataIndividual di14=new DataIndividual( "China wok", "Tempura de cerdo, vegetales mixtos, almendras, salsa de soja y naranja, acompañado de tallarines o arroz.", wb, 240, foto1);
        Individual i14=new Individual(di14);
        MP.addProductoIndividual(di14.getNombre(),i14);
        MU.addProductoIndividual(di14.getRestaurante().getnickname(),i14);
        
        DataIndividual di15=new DataIndividual( "Classic wok de pollo", "Pollo, vegetales mixtos, salsa agridulce, salsa de soja y cebollita de verdeo, acompañado de tallarines o arroz.", wb, 230, cpw);
        Individual i15=new Individual(di15);
        MP.addProductoIndividual(di15.getNombre(),i15);
        MU.addProductoIndividual(di15.getRestaurante().getnickname(),i15);
        
        DataIndividual di16=new DataIndividual( "Classic wok de cerdo", "Cerdo, vegetales mixtos, jengibre, salsa de ostras y ralladura de lima, acompañado de tallarines o arroz.", wb, 230, foto1);
        Individual i16=new Individual(di16);
        MP.addProductoIndividual(di16.getNombre(),i16);
        MU.addProductoIndividual(di16.getRestaurante().getnickname(),i16);
    }
    /*public void ProductosPromociones(){
        Restaurante 
        DataPromocion(Restaurante res,String nombre, String descripcion, double precioTotal, boolean activa, double descuento, Map CantidadProductos,File foto){

    }*/
    public void DatosPrecargado(){
        Clientes();
        Categorias();
        Restaurantes();
        ProductosIndividuales();
        JOptionPane.showMessageDialog(null,"Datos Cargados","DATOS PRECARGADOS",JOptionPane.INFORMATION_MESSAGE);
        
    }
            
     



    
}
