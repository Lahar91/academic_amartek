import "./index.css";

function LokerNotFound() {
	return (
		<div className="loker-not-found">
			<img
				src={`${process.env.PUBLIC_URL}/not-founded.svg`}
				alt="Loker tidak ditemukan!"
			/>
			<p>Lowongan pekerjaan tidak ditemukan!</p>
		</div>
	);
}

export default LokerNotFound;
