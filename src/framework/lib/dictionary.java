package framework.lib;
/**
 * dictionary library contains all the messeges of the frame
 * @author Oscar Otero
 * @version 1.0 18/12/2015 
 */
public class dictionary {
	/**Main Menu**/
	public static final String [][] OPTIONS_MAIN = {{"    Admin    ", "    Client    ", "  Registered User  ","  Configuration  ", "    Exit    "},	
			{" Administrador ", "    Cliente    ", "  Usuario Registrado  ","  Configuracion  ", "    Salir    "},	
			{" Administrador ", "    Client    ", "  Usuari Registrat  ","  Configuracio  ", "    Eixida    "},	
			{" Administrador    ", "  Cliente  ", "  Usuario rexistrado  ","  Configuracion  ", "    Sair    "}};
	public static final String [] MAIN_MESS = {"Select an User type", "Seleccione un tipo de usuario", "Trie un tipus d'usuari", "Escolla un tipo de usuario"};
	public static final String [] MAIN_TITLE = {"User Objects Main", "Menu principal de objetos usuario", "Menu principal d'objectes usuari", "Menu principal de obxetos usuario"};
	public static final String [] BYE_MESS = {"Thanks for use 'FrameworkAPP'","Gracias por usar 'FrameworkAPP'","Gracies per utilitzar 'FrameworkAPP'","Gracias por usar 'FrameworkAPP'"};
	public static final String [] BYE_TITLE = {"See you soon","Hasta pronto","Fins aviat","Ata pronto"};
	
	/**Menu Settings**/
	public static final String [][] SETTING_OPT ={{"  Date  ", " Currency ", " Decimal ", " Language ","  Main  "},	
			{"  Fecha  ", " Moneda ", " Decimales ", "  Idioma  ","  Menu  "}, 
			{"  Data  ", " Moneda ", " Decimals ", "  Idioma  ","  Menu  "},	
			{"  Data  ", "  Moeda  ", " Decimales ", " Idioma ","  Menu  "}};
	public static final String [] SETT_TYPE_MESS = {"Select one configuration option","Selecciona una opcion de configuracion","Selecciona una opcio de configuracio","Escolle unha opcion de configuracion"};
	public static final String [] SETT_TYPE_TITLE = {"Menu configuration","Menu de configuracion","Menu de configuracio","Menu de configuracio"};
	public static final String [][] CURRENCY_OPT = {{"Euro","Dollar","Pound"},{"Euros","Dolares","Libras"},{"Euros","Dolars","Lliures"},{"Euros","Dolares","Libras"}};
	public static final String [] CURR_OPT_MESS = {"Select currency type", "Seleccione el tipo de moneda", "seleccione el tipo de moneda", "Escolla o tipo da moeda"};
	public static final String [] CURR_OPT_TITLE = {"Menu settings currency", "Menu ajustes moneda", "Menu ajusts de moneda", "Menu axustes de moeda"};
	public static final String [] DATE_OPT = {"dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd"};
	public static final String [] DATE_OPT_MESS = {"Select date format","Seleccione el formato de fecha","Trie el format de data","Escolla o formato da data"};
	public static final String [] DATE_OPT_TITLE = {"Menu settings date format","Menu ajustes formato fecha","Menu ajusts format data","Menu axustes formato data"};
	public static final String [] DECIMAL_OPT = {".0",".00",".000"};
	public static final String [] DECIMAL_OPT_MESS = {"Select decimal format","Seleccione el formato de los decimales","Trie el format dels decimals","Escolla o formato dos decimais"};
	public static final String [] DECIMAL_OPT_TITLE = {"Menu settings decimal format","Menu ajustes formato decimales","Menu ajusts format decimals","Menu axustes formato decimais"};
	public static final String [] LANG_OPT = {"UK", "ES", "VLC", "GZ"};
	public static final String [] LANG_OPT_MESS = {"Select language","Seleccione idioma","Trie llengua","Escolla lingua"};
	public static final String [] LANG_OPT_TITLE = {"Menu settings lenguage","Menu ajustes idioma","Menu ajusts llengua","Menu settings lingua"};
	public static final String [][] LANG_OPT_CHOICE ={{" English ", " Spanish ", " Valencian ", " Galician "},{" Ingles ", " Espanol ", " Valenciano ", " Gallego "},{" Angles ", " Castella ", " Valencia ", " Galleg "},{" Ingles ", " Castela ", " Valenciano ", " Galego "}};
	
	/**---------->menu_user<----------**/
	public static final String MENU_EXC = "ERROR";
	/**MenuAdmin**/
	public static final String AMO_CASE0 = "Create empty Admin";
	public static final String AMO_CASE1 = "Create primary key Admin";
	public static final String AMO_CASE2 = "Create full Admin";
	public static final String AMO_CASE3 = "Change atribute";
	public static final String AMO_CASE4 = "Show Admin object";
	public static final String AMO_CASE5 = "Show selected atribute";
	public static final String AMO_CASE6 = "Delete selected atribute";
	public static final String AMO_CASE7 = "Delete Admin";
	public static final String AMO_EXIT = "Back";
	public static final String [][]ADMIN_MENU_OPT ={{AMO_CASE0, AMO_CASE1, AMO_CASE2, AMO_CASE3, AMO_CASE4, AMO_CASE5, AMO_CASE6, AMO_CASE7, AMO_EXIT },
			{"Crear administrador vacio", "Crear administrador solo con DNI", "Crear administrador completo",	"Cambiar atributos", "Ver atributos del administrador", "Ver atributo seleccionado ", "Borrar atributo seleccionado", "Borrar administrador", "Atras"},
			{"Crear administrador buit", "Crear administrador soles amb DNI", "Crear administrador complet",	"Cambiar atributs", "Mostrar atributs del administrador", "Mostrar atribut seleccionat", "Borrar atribut seleccionat", "Esborrar administrador", "Enrrere"},
			{"Crear administrador vacio", "Crear administrador so co DNI", "Crear administrador completo",	"Cambiar atributos", "Mostrar atributos do administrador", "Ver atributo escollido", "Borrar atributo escollido", "Borrar administrador", "Voltar"}};
	public static final String [] ADMIN_MENU_MESS = {"Select an Admin Object function:","Elija una funcion de administrador","Trie una accio de administrador","Escolla unha opcion do administrador"};
	public static final String [] ADMIN_MENU_TITLE = {" Admin Secondary Menu "," Menu secundario administrador "," Menu secundari administrador "," Menu secundario administrador "};
	public static final String [] AMO_ERR ={"You must create an Admin object first ","Tiene que crear un administrador primero","Tens que crear l'administrador primer","Tes que ter o administrador creado"};
	public static final String [] AMO_ERRT = {"Admin empty","Administrador vacio","Administrador buit","Administrador vacio"};
	public static final String [] AMO_DELETED ={"Admin Object deleted", "Administrador eliminado","Administrador eliminat", "Administrador eliminado"};
	public static final String [] AMO_VALUES = {"Admin Atribute Values","Valor de los atributos del administrador","Valor dels atributs de administrador","Valor dos atributos do administrador"};
	/**MenuClient**/
	public static final String CMO_CASE0 = "Create empty Client" ;
	public static final String CMO_CASE1 = "Create primary key Client";
	public static final String CMO_CASE2 = "Create full Client";
	public static final String CMO_CASE3 = "Change atribute";
	public static final String CMO_CASE4 = "Show Client object";
	public static final String CMO_CASE5 = "Show selected atribute";
	public static final String CMO_CASE6 = "Delete selected atribute";
	public static final String CMO_CASE7 = "Delete Client";
	public static final String CMO_EXIT = "Back";
	public static final String [][]CLIENT_MENU_OPT ={{CMO_CASE0, CMO_CASE1, CMO_CASE2,CMO_CASE3, CMO_CASE4, CMO_CASE5, CMO_CASE6, CMO_CASE7, CMO_EXIT},
			{"Crear cliente vacio", "Crear cliente solo con DNI", "Crear cliente completo","Cambiar atributos", "Ver atributos del cliente", "Ver atributo seleccionado ", "Borrar atributo seleccionado", "Borrar cliente", "Atras"},
			{"Crear client buit", "Crear client soles amb DNI", "Crear client complet","Cambiar atributs", "Mostrar atributs del client", "Mostrar atribut seleccionat", "Borrar atribut seleccionat", "Esborrar client", "Enrrere"},
			{"Crear cliente vacio", "Crear cliente so co DNI", "Crear cliente completo","Cambiar atributos", "Mostrar atributos do cliente", "Ver atributo escollido", "Borrar atributo escollido", "Borrar cliente", "Voltar"}};
	public static final String []CLIENT_MENU_MESS ={"Select a Client Object function:","Elija una funcion de cliente","Trie una accio de client","Escolla unha opcion do cliente"};
	public static final String []CLIENT_MENU_TITLE = {" Client Secondary Menu "," Menu secundario cliente "," Menu secundari client "," Menu secundario cliente "};
	public static final String [] CMO_ERR ={"You must create a Client object first ","Tiene que crear un cliente primero","Te que crear un client primer","Ten que ter o cliente creado"};
	public static final String [] CMO_ERRT = {"Client empty","Cliente vacio","Cliente buit","Cliente vacio"};
	public static final String [] CMO_DELETED ={"Client Object deleted", "Cliente eliminado","Client eliminat", "Cliente eliminado"};
	public static final String [] CMO_VALUES = {"Client Atribute Values","Valor de los atributos de cliente","Valor dels atributs de client","Valor dos atributos do cliente"};
	
	/**MenuRegisteredU**/
	public static final String RMO_CASE0 = "Create empty Registered User";
	public static final String RMO_CASE1 = "Create primary key Registered User";
	public static final String RMO_CASE2 = "Create full Registered User";
	public static final String RMO_CASE3 = "Change atribute";
	public static final String RMO_CASE4 = "Show Registered User object";
	public static final String RMO_CASE5 = "Show selected atribute";
	public static final String RMO_CASE6 = "Delete selected atribute";
	public static final String RMO_CASE7 = "Delete Registered User";
	public static final String RMO_EXIT = "Back";
	public static final String [][]REGU_MENU_OPT = {{RMO_CASE0, RMO_CASE1, RMO_CASE2,RMO_CASE3, RMO_CASE4, RMO_CASE5, RMO_CASE6, RMO_CASE7, RMO_EXIT},
			{"Crear usuario registrado vacio", "Crear usuario registrado solo con DNI", "Crear usuario registrado completo","Cambiar atributos", "Ver atributos del usuario registrado", "Ver atributo seleccionado ", "Borrar atributo seleccionado", "Borrar usuario registrado", "Atras"},
			{"Crear usuari registrat buit", "Crear usuari registrat soles amb DNI", "Crear usuari registrat complet","Cambiar atributs", "Mostrar atributs del usuari registrat", "Mostrar atribut seleccionat", "Borrar atribut seleccionat", "Esborrar usuari registrat", "Enrrere"},
			{"Crear usuario rexistrado vacio", "Crear usuario rexistrado so co DNI", "Crear usuario rexistrado completo","Cambiar atributos", "Mostrar atributos do usuario rexistrado", "Ver atributo escollido", "Borrar atributo escollido", "Borrar usuario rexistrado", "Voltar"}};
	public static final String []REGU_MENU_MESS ={"Select an Registered User Object function:","Elija una funcion de usuario registrado","Trie una accio de usuari registrat","Escolla unha opcion do usuario rexistrado"};
	public static final String []REGU_MENU_TITLE ={" Registered User Secondary Menu "," Menu secundario usuario registrado "," Menu secundari usuari registrat "," Menu secundario usuario rexistrado"};
	public static final String [] RMO_ERR ={"You must create a Registered User object first ","Tiene que crear un usuario registrado primero","Te que crear un usuari registrat primer","Ten que ter o usuario rexistrado creado"};
	public static final String [] RMO_ERRT = {"Registered User empty","Usuario registrado vacio","Usuari registrat buit","Usuario rexistrado vacio"};
	public static final String [] RMO_DELETED ={"Registered User Object deleted", "Usuario registrado eliminado","Usuari registrat eliminat", "Usuario rexistrado eliminado"};
	public static final String [] RMO_VALUES = {"Registered User Atribute Values","Valor de los atributos de Usuario registrado","Valor dels atributs de usuari registrat","Valor dos atributos do usuario rexistrado"};
	
}
