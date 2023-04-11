import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import CariLowongan from "./components/page/user_management/cari_lowongan";
import Dashboard from "./components/template/admin/dashboard";
import UserView from "./components/template/admin/user-view";

// ini untuk route url aplikasi
function App() {
	return (
		<Router>
			<Routes>
				<Route path="/" element={<CariLowongan />} />
				<Route path="/dashboard" element={<Dashboard />} />
				<Route path="/user" element={<UserView />} />
			</Routes>
		</Router>
	);
}

export default App;
