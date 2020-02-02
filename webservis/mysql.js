var mysql = require('mysql');



var connection = mysql.createConnection({
    host:'localhost',
    user:'root',
    password: '',
    database:'webservis'
});


connection.connect(function(err) {
    if (err) throw err;
   
      console.log('connect');

    });


  module.exports = connection;
