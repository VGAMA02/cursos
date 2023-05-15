import { Component, OnInit } from '@angular/core';
import { Article } from '../../models/article';
import { ArticleService } from '../../services/article.service';
import { Router, Params, ActivatedRoute } from '@angular/router';
import { Global } from 'src/app/services/global';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-article-create',
  templateUrl: './article-create.component.html',
  styleUrls: ['./article-create.component.css'],
  providers: [ArticleService]
})
export class ArticleCreateComponent implements OnInit {
  public article!: Article;
  public status!: string;
  public page_title!: string;
  afuConfig = {
    multiple: false,
    formatsAllowed: ".jpg,.png,.gif,.jpeg",
    maxSize: 50,
    uploadAPI:  {
      url:Global.url+'upload-image',
    },
    theme: "attachPin",
    hideProgressBar: true,
    hideResetBtn: true,
    hideSelectBtn: false,
    replaceTexts: {
      selectFileBtn: 'Select Files',
      resetBtn: 'Reset',
      uploadBtn: 'Upload',
      dragNDropBox: 'Drag N Drop',
      attachPinBtn: 'Sube la imagen del articulo',
      afterUploadMsg_success: 'Successfully Uploaded !',
      afterUploadMsg_error: 'Upload Failed !',
    }
   
  };

  constructor(
    private _articleService: ArticleService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.article = new Article('', '', '', '', null);
    this.page_title = "Crear Articulo";
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this._articleService.create(this.article).subscribe(
      (response) => {
        if (response.status == 'success') {
          this.status = 'success';
          this.article = response.article;
          console.log(response);

            Swal.fire({
            title: 'Articulo creado',
            text: 'Su articulo ha sido creado exitosa mente',
            icon: 'success',
            confirmButtonText: 'Perfecto!'
          });

          this._router.navigate(['/blog']);
        }
        else {
          this.status = 'error de status';
          console.log(this.status);
          console.log(response);
          Swal.fire({
            title: 'Articulo NO creado',
            text: 'Su articulo no se creo',
            icon: 'error',
            confirmButtonText: 'Chale!'
          });
        }
      },
      error => {
        console.log(error);
        this.status = 'error';
      }
    );
  }

  imageUpload(data:any){
    //let image_data = JSON.parse(data.body); 
    //alert(data.body.image);    
    this.article.image = data.body.image;
  }

}
