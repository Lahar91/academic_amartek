// import css nya
import "./index.css";
import { useState, useEffect } from "react";

// test

function Navbar() {
	// state buat bikin sticky navbar ketika di scroll
	const [stickyClass, setStickyClass] = useState("");

	useEffect(() => {
		// untuk menambahkan event scroll
		window.addEventListener("scroll", stickNavbar);

		return () => {
			window.removeEventListener("scroll", stickNavbar);
		};
	}, []);

	const stickNavbar = () => {
		if (window !== undefined) {
			// atur ukuran layar pada saat scroll
			let windowHeight = window.scrollY;
			windowHeight > 300 ? setStickyClass("sticky-nav") : setStickyClass("");
		}
	};

	return (
		<div className={`wrap-nav ${stickyClass}`}>
			<nav className="navbar">
				<div className="nav-logo">
					<img src="/amartek-logo.png" alt="Logo App" />
				</div>
				<div className="nav-link">
					<ul>
						<li>
							<a href="/#">Cari Lowongan</a>
						</li>
						<li>
							<a href="/#">Kontak Kami</a>
						</li>
					</ul>
					<div className="nav-button">
						<button>Masuk</button>
						<button>Daftar</button>
					</div>
				</div>
			</nav>
		</div>
	);
}

export default Navbar;
