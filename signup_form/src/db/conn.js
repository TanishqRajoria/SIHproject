//to connect database to our express
const mongoose =require("mongoose");

//to connect our database to compass

mongoose.connect("mongodb://127.0.0.1:27017/signup_Form", {
    useNewUrlParser: true,
    useUnifiedTopology: true,

}).then(() => {
    console.log(`connection successful`);
}).catch((e) => {
    console.error(`Error connecting to the database: ${e.message}`);
})


