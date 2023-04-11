import "./index.css";

import { RiEditBoxLine } from "react-icons/ri";
import { IoIosAddCircleOutline } from "react-icons/io";
import { MdOutlineDeleteOutline } from "react-icons/md";
import ModalCV from "../admin/modal-cv";
import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";

function CurriculumVitae() {
	const [show, setShow] = useState(false);

	const handleClose = () => setShow(false);
	const handleShow = () => setShow(true);

	return (
		<div className="cv-wrap">
			<div className="cv-container">
				{/* data diri */}
				<div className="cv-data-diri">
					<div className="edit-data-diri" onClick={handleShow}>
						<RiEditBoxLine />
					</div>
					<div className="img-data-diri">
						<img src="/dummyimg-card.jpg" alt="Foto CV" />
					</div>
					<p className="nama-data-diri">nama CV dummy</p>
					<div className="flex-title">
						<div className="cv-title">
							<p>Date of Birth</p>
							<p>Phone</p>
							<p>Address</p>
						</div>
						<div className="cv-title-value">
							<p>2000-17-03</p>
							<p>+08822123121</p>
							<p>Jln. Angkasa Timur</p>
						</div>
					</div>

					<div className="cv-summary-data-diri">
						<p>Summary</p>
						<p>Fresh graduate</p>
					</div>
				</div>

				{/* project experience */}
				<div className="cv-project-exp">
					{/* item project experience */}
					<div className="pe-judul">
						<p>Project Experience</p>
						<div className="add-pe">
							<IoIosAddCircleOutline />
						</div>
					</div>
					<div className="pe-value-container">
						<div className="pe-value">
							<div className="pe-value-info">
								<p>GDP</p>
								<p>2022-02-18 to 2022-03-10</p>
								<p>
									Lorem ipsum dolor sit, amet consectetur adipisicing elit. Illo
									voluptates et, harum obcaecati alias omnis vitae ipsam sapiente totam
									iusto?
								</p>
							</div>
							<div className="pe-value-action">
								<div className="pe-action-edit">
									<RiEditBoxLine />
								</div>
								<div className="pe-action-delete">
									<MdOutlineDeleteOutline />
								</div>
							</div>
						</div>

						{/* item project experience */}
						<div className="pe-value">
							<div className="pe-value-info">
								<p>GDP</p>
								<p>2022-02-18 to 2022-03-10</p>
								<p>
									Lorem ipsum dolor sit, amet consectetur adipisicing elit. Illo
									voluptates et, harum obcaecati alias omnis vitae ipsam sapiente totam
									iusto?
								</p>
							</div>
							<div className="pe-value-action">
								<div className="pe-action-edit">
									<RiEditBoxLine />
								</div>
								<div className="pe-action-delete">
									<MdOutlineDeleteOutline />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<ModalCV show={show} hide={handleClose} />
		</div>
	);
}

export default CurriculumVitae;
