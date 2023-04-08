import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import CariLowongan from "./components/template/user_management/cari_lowongan";
import Tentang from "./components/template/user_management/tentang";

function App() {
	return (
		<Router>
			<Routes>
				<Route path="/" element={<CariLowongan />} />
				<Route path="/tentang" element={<Tentang />} />
			</Routes>
		</Router>
	);
}

export default App;
