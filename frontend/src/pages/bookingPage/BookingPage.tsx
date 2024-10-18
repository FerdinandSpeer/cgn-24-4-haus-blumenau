import GuestForm from "../../components/guestForm/GuestForm.tsx";
import NavBar from "../../components/navBar/NavBar.tsx";
import "./BookingPage.css"

export default function BookingPage() {
    return (
        <>
            <NavBar/>
            <h1 className="pageTitle">Booking Page</h1>
            <GuestForm/>
        </>
    );
}