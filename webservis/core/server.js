var http = require("http");
var emp = require("../controllers/controller");
var path = require('path');
var fs = require('fs');
var stringbuilder = require('stringbuilder');
var qs = require("querystring");

function verisil(req, res){
    var sb2= new stringbuilder({newline: "\r\n"});
    
    sb2.appendLine("<html>");
    sb2.appendLine("     <form action='/verisil' method='GET'>");
    sb2.appendLine("         <tr>");
    sb2.appendLine("             <td><input type='text' id='id' name='id' value='' placeholder='Haberin Id'si/></td>");
    sb2.appendLine("         </tr>");
    sb2.appendLine("         <div></div>");
    sb2.appendLine("         <p></p>");
    sb2.appendLine("         <div></div>");
    sb2.appendLine("             <input type='submit' class='btn btn-primary' value='Sil' ");
    sb2.appendLine("         </tr>");
    sb2.appendLine("</html>");
    
    sb2.build(function(err, result){
    
        res.write(result);
        res.end();
    });
    };

    function veriguncelle(req, res){
        var sb3= new stringbuilder({newline: "\r\n"});
        
        sb3.appendLine("<html>");
        sb3.appendLine("<body>");
        sb3.appendLine("     <form action='/veriguncelle' method='GET'>");
        sb3.appendLine("         <table>");
        sb3.appendLine("         <tr>");
        sb3.appendLine("             <td><input type='text' id='id' name='id' value='' placeholder='Haberin Idsi'/></td>");
        sb3.appendLine("         </tr>");
        sb3.appendLine("         <tr>");
        sb3.appendLine("             <td><input type='text' id='haberurl' name='haberurl' value='' placeholder='Haberin Urlsi'/></td>");
        sb3.appendLine("         </tr>");
        sb3.appendLine("         <tr>");
        sb3.appendLine("             <td><input type='text' id='haberbaslik' name='haberbaslik' value='' placeholder='Haberin Basligi'/></td>");
        sb3.appendLine("         </tr>");
        sb3.appendLine("         <tr>");
        sb3.appendLine("         <td><input type='text' id='habericerik' name='habericerik' value=''  placeholder='Haberin Icerigi' /></td>");
        sb3.appendLine("         </tr>");
        sb3.appendLine("         <tr>");
        sb3.appendLine("         </table>");
        sb3.appendLine("         <label for='haberturu'>Haber Turu</label>");
        sb3.appendLine("         <select id='haberturu' name='haberturu'>");
        sb3.appendLine("             <option value='sondakika'>SonDakika</option>");
        sb3.appendLine("             <option value='spor'>Spor</option>");
        sb3.appendLine("             <option value='siyaset'>Siyaset</option>");
        sb3.appendLine("             <option value='ekonomi'>Ekonomi</option>");
        sb3.appendLine("             <option value='saglik'>Saglik</option>");
        sb3.appendLine("             <option value='gundem'>Gundem</option>");
        sb3.appendLine("         </select>");
        sb3.appendLine("         <div></div>");
        sb3.appendLine("         <p></p>");
        sb3.appendLine("         <span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span>");
        sb3.appendLine("         <input id='yayintarihi' type='date' class='form-control' name='yayintarihi' placeholder='Yayinlanma Tarihi'>");
        sb3.appendLine("         <p></p>");
        sb3.appendLine("         <div></div>");
        sb3.appendLine("             <input type='submit' class='btn btn-primary' value='guncelle' ");
        sb3.appendLine("         </tr>");
        sb3.appendLine("</form>");
        sb3.appendLine("</body>");
        sb3.appendLine("</html>");
        
        
        sb3.build(function(err, result){
        
            res.write(result);
            res.end();
        });
        };

function verigir(req, res){
var sb= new stringbuilder({newline: "\r\n"});

sb.appendLine("<html>");
sb.appendLine("<body>");
sb.appendLine("     <form action='/yukle' method='POST'>");
sb.appendLine("         <table>");
sb.appendLine("         <tr>");
sb.appendLine("             <td><input type='text' id='haberurl' name='haberurl' value='' placeholder='Haberin Urlsi'/></td>");
sb.appendLine("         </tr>");
sb.appendLine("         <tr>");
sb.appendLine("             <td><input type='text' id='haberbaslik' name='haberbaslik' value='' placeholder='Haberin Basligi'/></td>");
sb.appendLine("         </tr>");
sb.appendLine("         <tr>");
sb.appendLine("         <td><input type='text' id='habericerik' name='habericerik' value=''  placeholder='Haberin Icerigi' /></td>");
sb.appendLine("         </tr>");
sb.appendLine("         <tr>");
sb.appendLine("         </table>");
sb.appendLine("         <label for='haberturu'>Haber Turu</label>");
sb.appendLine("         <select id='haberturu' name='haberturu'>");
sb.appendLine("             <option value='sondakika'>SonDakika</option>");
sb.appendLine("             <option value='spor'>Spor</option>");
sb.appendLine("             <option value='siyaset'>Siyaset</option>");
sb.appendLine("             <option value='ekonomi'>Ekonomi</option>");
sb.appendLine("             <option value='saglik'>Saglik</option>");
sb.appendLine("             <option value='gundem'>Gundem</option>");
sb.appendLine("         </select>");
sb.appendLine("         <div></div>");
sb.appendLine("         <p></p>");
sb.appendLine("         <span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span>");
sb.appendLine("         <input id='yayintarihi' type='date' class='form-control' name='yayintarihi' placeholder='Yayinlanma Tarihi'>");
sb.appendLine("         <p></p>");
sb.appendLine("         <div></div>");
sb.appendLine("             <input type='submit' class='btn btn-primary' value='ekle' ");
sb.appendLine("         </tr>");
sb.appendLine("</form>");
sb.appendLine("</body>");
sb.appendLine("</html>");


sb.build(function(err, result){

    res.write(result);
    res.end();
});
};

http.createServer(function(req, res){
    switch(req.method){
        case "GET":
            if(req.url === "/"){
                console.log("/ urlsi çağrıldı");

                verigir(req,res);

            }
            if(req.url === "/haber"){
                emp.getList(req, res);
            
            }
            if(req.url === "/haber/SonDakika"){
                emp.getsondakika(req, res);
            
            }
            if(req.url === "/haber/Spor"){
                emp.getspor(req, res);
            
            }
            if(req.url === "/haber/Siyaset"){
                emp.getsiyaset(req, res);
            
            }
            if(req.url === "/haber/Ekonomi"){
                emp.getekonomi(req, res);
            
            }
            if(req.url === "/haber/Saglik"){
                emp.getsaglik(req, res);
            
            }
            if(req.url === "/haber/Gundem"){
                emp.getgundem(req, res);
            
            }
            if(req.url === "/verisil"){
                verisil(req, res);
            }
            if(req.url ==="/veriguncelle"){
                veriguncelle(req,res);
            }
            var str=req.url;
            var sonhal=str.substring(0,str.lastIndexOf('/'),str.length);

            console.log(sonhal);
            if(sonhal == "/begendi"){
                var empnoPatt = "[0-9]+";
                var patt = new RegExp("/begendi/"+empnoPatt);
                patt = new RegExp(empnoPatt);
                var empno = patt.exec(req.url);
                emp.begendim(req, res, empno);
                res.end();
            }

            if(sonhal == "/begenmedi"){
                var empnoPatt2 = "[0-9]+";
                var patt2 = new RegExp("/begenmedi/"+empnoPatt2);
                patt2 = new RegExp(empnoPatt2);
                var empno2 = patt2.exec(req.url);
                emp.begenmedim(req, res, empno2);
                res.end();
            }
            
            if(sonhal == "/goruntu"){
                var empnoPatt3 = "[0-9]+";
                var patt3 = new RegExp("/goruntu/"+empnoPatt3);
                patt3 = new RegExp(empnoPatt3);
                var empno3 = patt3.exec(req.url);
                emp.goruntu(req, res, empno3);
                res.end();
            }

        break;

        case "POST":
        if(req.url === "/haber"){

            var reqBody = '';
            req.on("data",function(data){
                reqBody += data;
            });
            req.on("end",function(){
                emp.add(req, res,reqBody);
            });
           res.end();
        };
        if(req.url === "/yukle"){
            var reqBody = '';
            req.on("data",function(data){
                reqBody += data;
            });
            req.on("end",function(){
              var formdata = qs.parse(reqBody);
            
              emp.yukle(req,res,formdata);
              
              
             
            });
            res.writeHead(302, {Location:"/"});
           res.end();
       
        };
        break;

        case "PUT":
        if(req.url === "/haber"){

            var reqBody = '';
            req.on("data",function(data){
                reqBody += data;
            });
            req.on("end",function(){
                emp.update(req, res,reqBody);
            });
           res.end();
        };
        break;
        case "DELETE":
            if(req.url === "/haber"){
                
            var reqBody = '';
            req.on("data",function(data){
                reqBody += data;
            });
            req.on("end",function(){
                emp.delete(req, res,reqBody);
            });
           res.end();
            }

        break;
        default:
        console.log("defaulta düştü");
        break;
    }

}).listen(9000, function(){
    console.log("Started Listening at:9000");
});