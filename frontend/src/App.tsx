import './App.css'
import {Route, Routes} from "react-router-dom";
import HomePage from "./pages/homePage/HomePage.tsx";
import BookingPage from "./pages/bookingPage/BookingPage.tsx";
import AdminDashboard from "./pages/adminDashboard/AdminDashboard.tsx";
import CalendarPage from "./pages/calendarPage/CalendarPage.tsx";
import {useState} from "react";


function App() {

    const [arrivalDate, setArrivalDate] = useState<string>("");
    const [departureDate, setDepartureDate] = useState<string>("");


    return (
        <>
        <Routes>
            <Route path={"/"} element={<HomePage/>}/>
            <Route path={"/calendar"} element={<CalendarPage setArrivalDate={setArrivalDate} setDepartureDate={setDepartureDate}/>}/>
            <Route path={"/bookingPage"} element={<BookingPage arrivalDate={arrivalDate} departureDate={departureDate}/>}/>
            <Route path={"/adminDashboard"} element={<AdminDashboard/>}/>
        </Routes>
        </>
    )
}

export default App
