// Primero, asegúrate de instalar la librería node-soap con:
// npm install soap

const soap = require('soap');

// URL del WSDL del servicio
const url = 'http://www.dneonline.com/calculator.asmx?WSDL';

// Parámetros para la operación "Add" (suma)
const args = {
  intA: 10,
  intB: 5
};

// Creamos el cliente SOAP a partir del WSDL
soap.createClient(url, (err, client) => {
  if (err) {
    console.error('Error al crear el cliente SOAP:', err);
    return;
  }
  console.log('Cliente SOAP creado correctamente');

  // Llamamos a la operación "Add" del servicio
  client.Add(args, (err, result) => {
    if (err) {
      console.error('Error al invocar la operación Add:', err);
      return;
    }
    console.log('Resultado de la suma:', result.AddResult);
  });
});