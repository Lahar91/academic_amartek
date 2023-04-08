import Footer from "../footer";
import Navbar from "../navbar";
import "./index.css";
import { useEffect } from "react";

function CariLowongan() {
	useEffect(() => {
		document.title = "Cari lowongan pekerjaan";
	}, []);

	return (
		<div className="cari-lowongan">
			<Navbar />

			<h3>test</h3>

			<Footer />
		</div>
	);
}

export default CariLowongan;
