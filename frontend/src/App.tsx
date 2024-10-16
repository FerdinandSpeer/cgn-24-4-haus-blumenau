import './App.css'
import {Route, Routes} from "react-router-dom";
import HomePage from "./pages/homePage/HomePage.tsx";
import BookingPage from "./pages/bookingPage/BookingPage.tsx";


function App() {



    return (
        <>
        <Routes>
            <Route path={"/"} element={<HomePage/>}/>
            <Route path={"/bookingPage"} element={<BookingPage/>}/>
        </Routes>
        </>
    )
}

export default App
