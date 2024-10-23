import AdminGuestList from "../../components/adminGuestList/AdminGuestList.tsx";
import NavBar from "../../components/navBar/NavBar.tsx";

type AdminDashboardProps = {
    arrivalDate: string;
    departureDate: string;
}

export default function AdminDashboard(props:AdminDashboardProps) {
    return (
        <div>
            <NavBar/>
        <h1>Admin Dashboard</h1>
            <AdminGuestList arrivalDate={props.arrivalDate} departureDate={props.departureDate} />
        </div>
    );
}