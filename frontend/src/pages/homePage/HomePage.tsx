import NavBar from "../../components/navBar/NavBar.tsx";
import "./HomePage.css";
import "../../components/navBar/NavBar.css";
import {useNavigate} from "react-router-dom";


export default function HomePage() {

    const navigate = useNavigate();

    return (
        <>
            <div className={"NavBar"}>
                <NavBar/>
            </div>
            <h1>Willkommen</h1>
            <button onClick={()=> navigate("/calendar")}>Hier Buchen!</button>
        </>
    );
}