import NavBar from "../../components/navBar/NavBar.tsx";
import "./HomePage.css";
import "../../components/navBar/NavBar.css";
import {useNavigate} from "react-router-dom";
import CalendarComponent from "../../components/calendar/CalendarComponent.tsx";


export default function HomePage() {

    const navigate = useNavigate();

    return (
        <>
            <div className={"NavBar"}>
                <NavBar/>
            </div>
            <h1>Willkommen</h1>
            <CalendarComponent/>
            <button onClick={()=> navigate("/bookingPage")}>Hier Buchen!</button>
        </>
    );
}