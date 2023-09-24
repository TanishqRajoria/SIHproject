const express =require("express");
const path =require("path");
const app = express();
const hbs =require("hbs");

//including database file

require("./db/conn");

const Register =require("./models/register");

const port = process.env.PORT || 3000;


//to connect html file to  backend
const static_path=path.join(__dirname,"../public")

// console.log(path.join(__dirname,"../public"));//it is used to find path name of html file
const template_path=path.join(__dirname,"../template/views");
const partials_path =path.join(__dirname,"../template/partials");


app.use(express.json());
app.use(express.urlencoded({extended:false}));

app.use(express.static(static_path));

//to define view engine

app.set("view engine","hbs")
//set view engine to next directory
app.set("views",template_path);
hbs.registerPartials(partials_path);

app.get("/",(req,res) =>{
    res.render("index")

});
app.get("/register",(req,res)=>{
    res.render("register")
});
//create a new user in our database
app.post("/register", async (req,res)=>{
    try{
        //to match password and confirm password
       const password =req.body.password;
       const Cpassword=req.body.confirmpassword;
       if(password === Cpassword){

        const registerEmployee =new Register({
            firstname:req.body.firstname,
            Last_name:req.body.Last_name,
            Email:req.body.Email,
            gender:req.body.gender,
            AadharNumber:req.body.AadharNumber,
            PhoneNumber:req.body.PhoneNumber,
            Lawyer_License_number:req.body.Lawyer_License_number,
            Age:req.body.Age,
            password:req.body.password,
           confirmpassword:req.body.confirmpassword,
            Address:req.body.Address,

        })
       const registered = await registerEmployee.save();
       res.status(201).render(index)
          

       }else{
        res.send("password are not matching")
       }


    } catch(error){
        res.status(400).send(error);
    }
})

app.listen(port,()=>{
    console.log(`server is running at port no ${port}`);
})