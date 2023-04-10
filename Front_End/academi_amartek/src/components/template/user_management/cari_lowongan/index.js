import TemplateCardLowongan from "../card_lowongan";
import Footer from "../footer";
import Navbar from "../navbar";
import "./index.css";
import { useEffect, useState, useRef } from "react";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { FiSearch } from "react-icons/fi";
import LokerNotFound from "../data_loker_not_found";

function TemplateCariLowongan() {
	const [searchLoker, setSearchLoker] = useState("");

	const inputRef = useRef(null);

	let judulLoker = [];

	useEffect(() => {
		document.title = "Daftar Lowongan Pekerjaan";
	}, []);

	// setingan untuk slider nya
	const settings = {
		dots: true,
		speed: 500,
		autoplay: true,
		infinite: true,
		slidesToShow: 3,
		slidesToScroll: 1,
		arrows: false,
		initialSlide: 0,
		responsive: [
			{
				breakpoint: 1155,
				settings: {
					slidesToShow: 2,
					centerMode: true,
					centerPadding: "0",
				},
			},
			{
				breakpoint: 768,
				settings: {
					slidesToShow: 1,
					centerMode: true,
					centerPadding: "0",
				},
			},
		],
	};

	// objek data dummy untuk card loker
	const objLoker = [
		{
			imgCard: "",
			judulCard: "test1",
			descCard: "",
			tanggalCard: "",
		},
		{
			imgCard: "",
			judulCard: "test1",
			descCard: "",
			tanggalCard: "",
		},
		{
			imgCard: "",
			judulCard: "test2",
			descCard: "",
			tanggalCard: "",
		},
		{
			imgCard: "",
			judulCard: "test3",
			descCard: "",
			tanggalCard: "",
		},
	];

	objLoker.map((e, i) => {
		return judulLoker.push(e.judulCard);
	});

	const showLoker = (data) => {
		return data.map((e, i) => {
			if (e.judulCard.toLowerCase().includes(searchLoker)) {
				return <TemplateCardLowongan key={i} judul={e.judulCard} />;
			}

			return null;
		});
	};

	return (
		<div className="cari-lowongan">
			<Navbar />

			<div className="search-loker">
				<div className="search-bar">
					<input
						type="text"
						id="search-loker"
						name="search-loker"
						placeholder="Search lowongan..."
						autoComplete="off"
						ref={inputRef}
						onKeyDown={(e) => {
							if (e.key === "Enter") {
								setSearchLoker(inputRef.current.value);
							}
						}}
					/>
				</div>
				<div className="btn-search">
					<button
						onClick={() => {
							setSearchLoker(inputRef.current.value);
						}}
					>
						<FiSearch />
					</button>
				</div>
			</div>

			{/* <SearchLowongan /> */}
			{searchLoker === "" ? (
				<Slider {...settings} className="wrap-card-lowongan">
					{showLoker(objLoker)}
				</Slider>
			) : // cek jika judul card sesuai dgn dummy data atau tidak
			judulLoker.indexOf(searchLoker) > -1 ? (
				<Slider {...settings} className="wrap-card-lowongan">
					{showLoker(objLoker)}
				</Slider>
			) : (
				<LokerNotFound />
			)}

			<Footer />
		</div>
	);
}

export default TemplateCariLowongan;
