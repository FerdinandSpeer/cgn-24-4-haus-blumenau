import GuestForm from "../../components/guestForm/GuestForm.tsx";
import NavBar from "../../components/navBar/NavBar.tsx";
import "./BookingPage.css"

type BookingPageProps = {
    arrivalDate: string;
    departureDate: string;
}


export default function BookingPage(props: BookingPageProps) {
    return (
        <>
            <NavBar/>
            <h1 className="pageTitle" >Buchung - Haus BlumenAu</h1>
            <GuestForm arrivalDate={props.arrivalDate} departureDate={props.departureDate}/>
        </>
    );
}