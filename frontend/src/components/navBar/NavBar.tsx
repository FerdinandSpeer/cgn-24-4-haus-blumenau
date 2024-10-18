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
                    <Link className={"NavBarElement"} to="/bookingPage">Booking</Link>
                </ul>
            </nav>
        </div>
    );
}