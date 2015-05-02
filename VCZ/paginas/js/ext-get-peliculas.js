Ext.onReady(function(){

				cargar_datos();
				generar_controladores();
			
});

cargar_datos = function(){
	
	data = [ [1,2,3,4,5,6],
			 [7,8,9,10,11,12]
		   ];
				/*datos[i].disco[1].firmware,
				datos[i].disco[2].modelo,
				datos[i].disco[3].serialNumber,
				datos[i].disco[4].sectoresPistas,
				datos[i].disco[5].cilindros];*/
	
	
	Ext.grid.dummyData = data;
}

generar_controladores = function(){
    
	var xg = Ext.grid;

    //	lector compartido
    var reader = new Ext.data.ArrayReader({}, [
       {name: 'cabezas'},
       {name: 'firmware'},
       {name: 'modelo'},
       {name: 'serialNumber'},
       {name: 'sectoresPistas'},
       {name: 'cilindros'}
    ]);
	
	var sm2 = new xg.CheckboxSelectionModel();
    
    /*
     * ================  Grilla  =======================
     */
	
	var grid = new xg.GridPanel({
        id:'button-grid',
        store: new Ext.data.Store({
            reader: reader,
            data: xg.dummyData
        }),
        cm: new xg.ColumnModel([
            sm2,
            {id:'cabezas',header: "Cabezas", width: 15, sortable: true, dataIndex: 'cabezas'},
            {header: "Firmware", width: 45, sortable: true, dataIndex: 'firmware'},
            {header: "Modelo", width: 35, sortable: true, dataIndex: 'modelo'},
            {header: "Numero de Serial", width: 30, sortable: true, dataIndex: 'serialNumber'},
            {header: "Sectores por Pista", width: 30, sortable: true, dataIndex: 'sectoresPistas'},
			{header: "Cilindros", width: 15, sortable: true, dataIndex: 'cilindros'}
        ]),
        sm: sm2,

        viewConfig: {
            forceFit:true
        },

        // botones internos
        buttons: [
					{text:'Volver', 
					handler:function(){
						}},
					{text:'Registrar',
					handler: function(){
								
								var r_params;
								
								discos = grid.getSelections()
								
								if (discos.length == 0){
									Ext.MessageBox.alert('Error', 'No se ha seleccionado ningun dispositivo');
								}else{
									for (var i = 0; i < discos.length; i++){
									sub_params = String.format('"cabezas":"{0}","cilindros":"{1}","sectoresPistas":"{2}","serialNumber":"{3}"',
										discos[i].data.cabezas,
										discos[i].data.cilindros,
										discos[i].data.sectoresPistas,
										discos[i].data.serialNumber);
										if (i == 0){
											r_params = String.format('[{"disco":{{0}}}', sub_params);	
										}else{
											r_params = r_params + ',' + String.format('{"disco":{{0}}}', sub_params);
										}
									}
									
									r_params = r_params + ']';
									
									Ext.Ajax.request({
										url : '/registrar_discos/registrar_discos',
									    params: {
											discos: r_params
										},
										method: 'POST',
										waitMsg:'Registrando los dispositivos seleccionados',
										success: function (result, request){
											var mensaje = '';
											
											var response = Ext.util.JSON.decode(result.responseText);
										
											for (var j = 0; j < response.length; j++){
												if (response[j].er){
													mensaje = mensaje + '<b>' + response[j].er + '</b><br>';
												}else if (response[j].msg){
													mensaje = mensaje + '<b>' + response[j].msg + '</b><br>';
												}
											}
											
											Ext.MessageBox.alert('Eventos realizados', mensaje);
										},
										failure: function (result, request) 
									    {
											Ext.MessageBox.alert('Error', 'Error al recibir de: /registrar_disco/registrar_discos');
										},
									    scope: this
									});	
								}
							}, 
					scope: this}],
        buttonAlign:'center',

        width:500,
        height:300,
        frame:true,
        title:'Panel de Dispositivos existentes',
        iconCls:'icon-grid'
    });
	
	var ventana = new Ext.Window({
        width: 500,
        height:300,
        frame: true,
		draggable: false,
		resizable: false,
        layout: 'fit',
        plain:true,
        bodyStyle:'padding:5px;',
        buttonAlign:'center',
        items: grid,
		renderTo: 'registrar_discos_window' 
    });
	
	var panel = new Ext.Panel({
        title: 'GetSmart',
        width:500,
        height: 500,
        bodyStyle: 'padding:10px;',     

        
        items: [
        	ventana
        ],
		
        renderTo: "registrar_discos_form"
    });
	
	ventana.show();
}

	