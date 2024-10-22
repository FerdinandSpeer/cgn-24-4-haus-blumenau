import AdminGuestList from "../../components/adminGuestList/AdminGuestList.tsx";
import NavBar from "../../components/navBar/NavBar.tsx";

export default function AdminDashboard() {
    return (
        <div>
            <NavBar/>
        <h1>Admin Dashboard</h1>
            <AdminGuestList />
        </div>
    );
}