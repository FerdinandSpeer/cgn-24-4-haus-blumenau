import NavBar from "../../components/navBar/NavBar.tsx";
import "./HomePage.css";
import "../../components/navBar/NavBar.css";


export default function HomePage() {
    return (
        <>
            <div className={"NavBar"}>
                <NavBar/>
            </div>
            <h1>Home Page</h1>
        </>
    );
}