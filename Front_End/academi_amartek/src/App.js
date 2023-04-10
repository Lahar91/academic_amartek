import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import CariLowongan from "./components/page/user_management/cari_lowongan";

// ini untuk route url aplikasi
function App() {
	return (
		<Router>
			<Routes>
				<Route path="/" element={<CariLowongan />} />
			</Routes>
		</Router>
	);
}

export default App;
