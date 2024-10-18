import {Link} from "react-router-dom";

export default function NavBar() {
    return(
        <div className={"NavBar"}>
            <nav>
                <ul id={"NavBarList"}>
                        <Link className={"NavBarElement"} to="/">Home</Link>
                        <Link className={"NavBarElement"} to="/bookingPage">Booking</Link>
                </ul>
            </nav>
        </div>
    );
}