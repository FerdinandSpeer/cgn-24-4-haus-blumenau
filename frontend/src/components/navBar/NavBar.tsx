import {Link} from "react-router-dom";
import "./NavBar.css";
import "../../assets/watzmann.png";

export default function NavBar() {
    return(
        <div className={"NavBar"}>
            <div className={"NavBarContent"}>
                <img src={"/src/assets/watzmann.png"} alt={"watzmann.png"} className={"Watzmann"}/>
                <h2>Haus Blumen Au</h2>
            </div>
            <nav>
                <ul id={"NavBarList"}>
                    <Link className={"NavBarElement"} to="/">Home</Link>
                    <Link className={"NavBarElement"} to="/calendar">Kalender</Link>
                    <Link className={"NavBarElement"} to="/bookingPage">Buchung</Link>
                    <Link className={"NavBarElement"} to="/adminDashboard">Admin Dashboard</Link>

                </ul>
            </nav>
        </div>
    );
}