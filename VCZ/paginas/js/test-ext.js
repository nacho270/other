Ext.apply(Ext.form.VTypes, {
    password: function(val, field) {
        if (field.initialPassField) {
            var pwd = Ext.getCmp(field.initialPassField);
            return (val == pwd.getValue());
        }
        return true;
    },

    passwordText: 'Las claves ingresada no coinciden'
});


Ext.onReady(function()
{    
	Ext.form.Field.prototype.msgTarget = 'side';

	/*
	* ================  Formulario  =======================
	*/

    var form = new Ext.FormPanel({
        labelWidth: 150, 
		url:'/config_adm/guardar',
        frame:true,
        title: 'Configuracion del administrador',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {
            width: 230
        },
        defaultType: 'textfield',

        items: [
				{
					fieldLabel: 'Direccion correo electronico',
					name: 'e_mail',
					allowBlank:false
				},
                {
                    fieldLabel: 'Clave',
                    inputType: 'password',
                    name: 'clave',
                    id: 'clave',
					allowBlank:false
                },
				{
                    fieldLabel: 'Confirmar clave',
                    inputType: 'password',
                    name: 'confirmar_clave',
                    vtype: 'password',
                    initialPassField: 'clave',
					allowBlank:false
                }]
    });
    
	form.addButton({
        text: 'Guardar',
        disabled:false,
        handler: function(){
            Ext.Ajax.request({
				url : '/config_adm/guardar',
			    params : form.getForm().getValues(),
				method: 'POST',
				waitMsg:'Guardando los datos',
				success: function (result, request){
					var response = Ext.util.JSON.decode(result.responseText);
					
					if (response.er){
						Ext.MessageBox.alert('Error', response.er);
					} else if (response.ok){
						Ext.MessageBox.alert('Exito', response.ok);
						 window.location = '/singin';
					}
				},
				failure: function (result, request) 
			    {
					Ext.MessageBox.alert('Error', 'Error al recibir de: /config_adm/guardar');
				},
			    scope: this
			});
        }
    });	
	
	var ventana = new Ext.Window({
        width: 500,
        height:200,
        frame: true,
		draggable: false,
		resizable: false,
        layout: 'fit',
        plain:true,
        bodyStyle:'padding:5px;',
        buttonAlign:'center',
        items: form,
		renderTo: "config_adm_window" 
    });
	
	var panel = new Ext.Panel({
        title: 'GetSmart',
        width:'auto',
        height: 500,
        bodyStyle: 'padding:10px;',     

       items: [
        	ventana
        ],
		
        renderTo: "config_adm_form"
    });

	ventana.show();
})