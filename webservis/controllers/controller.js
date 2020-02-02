var mysql = require("../mysql");
var qs = require("querystring");

exports.getList =  function(req, res){
    mysql.query("SELECT * FROM webservis.haber", function (err,result){
        if(err) console.log("hata çıktı => "+err);
    

        res.write(JSON.stringify(result));
        res.end();
    });
};


exports.getsondakika = function(req, res ){
    mysql.query("SELECT * FROM webservis.haber WHERE haberturu = 'sondakika'" , function (err,result){
        if(err) console.log("hata çıktı => "+err);
    

        res.write(JSON.stringify(result));
        res.end();
    });
};
exports.getspor = function(req, res ){
    mysql.query("SELECT * FROM webservis.haber WHERE haberturu = 'spor'" , function (err,result){
        if(err) console.log("hata çıktı => "+err);
    

        res.write(JSON.stringify(result));
        res.end();
    });
};
exports.getsiyaset = function(req, res ){
    mysql.query("SELECT * FROM webservis.haber WHERE haberturu = 'siyaset'" , function (err,result){
        if(err) console.log("hata çıktı => "+err);
    

        res.write(JSON.stringify(result));
        res.end();
    });
};
exports.getekonomi = function(req, res ){
    mysql.query("SELECT * FROM webservis.haber WHERE haberturu = 'ekonomi'" , function (err,result){
        if(err) console.log("hata çıktı => "+err);
    

        res.write(JSON.stringify(result));
        res.end();
    });
};
exports.getsaglik = function(req, res ){
    mysql.query("SELECT * FROM webservis.haber WHERE haberturu = 'saglik'" , function (err,result){
        if(err) console.log("hata çıktı => "+err);
    

        res.write(JSON.stringify(result));
        res.end();
    });
};
exports.getgundem = function(req, res ){
    mysql.query("SELECT * FROM webservis.haber WHERE haberturu = 'gundem'" , function (err,result){
        if(err) console.log("hata çıktı => "+err);
    

        res.write(JSON.stringify(result));
        res.end();
    });
};


exports.add = function(req,res , reqBody){
    try {
        if(!reqBody) console.log("Input not valid");
        
        var data = JSON.parse(reqBody)
  
        if(data){
            mysql.query('insert into haber(haberresim,haberbaslik,habericerik,haberturu,yayintarihi)values(?,?,?,?,?)',[data.haberurl,data.haberbaslik,data.habericerik,data.haberturu,data.yayintarihi],function(err){
                if(err){
                    console.log(err);
                }
            });
        }else{
            console.log("Input not valid2");
        }
    }
    catch(ex){

    }
};

exports.yukle = function(req,res , reqBody){
    try {
        if(!reqBody) console.log("Input not valid");
        
     console.log(reqBody);
     
  
        if(reqBody){
            mysql.query('insert into haber(haberresim,haberbaslik,habericerik,haberturu,yayintarihi)values(?,?,?,?,?)',[reqBody.haberurl,reqBody.haberbaslik,reqBody.habericerik,reqBody.haberturu,reqBody.yayintarihi],function(err){
                if(err){
                    console.log(err);
                }
            });
        }else{
            console.log("Input not valid2");
        }
    }
    catch(ex){

    }
};

exports.update = function(req,res , reqBody){
        try {
        if(!reqBody) console.log("Input not valid");
        
        var data = JSON.parse(reqBody)

        var sql = "UPDATE haber SET ";
        if(data.haberurl){
            sql +=" haberresim='"+data.haberurl + "',";
        }

        if(data.haberbaslik){
            sql +=" haberbaslik='"+data.haberbaslik + "',";
        }

        if(data.habericerik){
            sql +=" habericerik='"+data.habericerik + "',";
        }

        if(data.haberturu){
            sql +=" haberturu='"+data.haberturu + "',";
        }

        if(data.yayintarihi){
            sql +=" yayintarihi='"+data.yayintarihi + "',";
        }
        
        sql=sql.substring(0,sql.lastIndexOf(','));
        sql += " WHERE id = " + data.id ;
  
       console.log(sql);
         mysql.query(sql);
        
    }
    catch(ex){
console.log("catche düştü");
    }
};

exports.delete = function(req,res , reqBody){
  
        if(!reqBody) console.log("Input not valid");
        
        var data = JSON.parse(reqBody)

        var sql = "DELETE FROM haber WHERE id="+data.id;
      

      
 
       console.log(sql);
         mysql.query(sql);
        
   
};

exports.begendim = function(req, res , id){

    console.log(id+" numaralı haber begenildi");

    mysql.query("UPDATE haber SET begendi=begendi+1 WHERE id="+id);

};

exports.begenmedim = function(req, res , id){

    console.log(id+" numaralı haber begenilmedi ");

    mysql.query("UPDATE haber SET begenmedi=begenmedi+1 WHERE id="+id);
    
    };

    exports.goruntu = function(req, res, id){

        mysql.query("UPDATE haber SET goruntulenme=goruntulenme+1 WHERE id="+id);
    
    }
