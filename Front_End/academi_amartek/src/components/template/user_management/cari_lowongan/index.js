import Footer from "../footer";
import Navbar from "../navbar";
import "./index.css";
import { useEffect } from "react";

function TemplateCariLowongan() {
	useEffect(() => {
		document.title = "Cari lowongan pekerjaan";
	}, []);

	return (
		<div className="cari-lowongan">
			<Navbar />

			<h3>
				Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam accusamus
				molestiae tempore dignissimos quis placeat, quae ab hic fugiat, accusantium neque
				nisi veniam dolor, a quos natus iusto mollitia. Nobis beatae sequi libero earum.
				Illum molestiae nulla optio commodi expedita. Enim vel dolorem quidem dolore illum
				reprehenderit quis delectus reiciendis quia consequuntur cupiditate, itaque magni
				dicta ad facilis nihil dolor animi necessitatibus tenetur doloremque recusandae
				laboriosam atque veniam. Asperiores libero, nulla tempore obcaecati culpa harum
				explicabo provident ducimus quo fugit laboriosam ipsum accusamus! Dolores hic,
				laborum, adipisci, optio repellendus ratione omnis quod fugit incidunt consectetur
				quae sit quisquam numquam iure?
			</h3>

			<Footer />
		</div>
	);
}

export default TemplateCariLowongan;
