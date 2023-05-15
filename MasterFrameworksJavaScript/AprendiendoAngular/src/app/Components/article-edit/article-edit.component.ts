import { Component, OnInit } from '@angular/core';
import { Article } from '../../models/article';
import { ArticleService } from '../../services/article.service';
import { Router, Params, ActivatedRoute } from '@angular/router';
import { Global } from 'src/app/services/global';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-article-edit',
  //templateUrl: '../article-create/article-create.component.html',
  templateUrl: './article-edit.component.html',
  styleUrls: ['./article-edit.component.css'],
  providers: [ArticleService]
})
export class ArticleEditComponent implements OnInit {

  public article!: Article;
  public status!: string;
  public is_edit!: boolean;
  public page_title!: string;
  public url!: string;

  afuConfig = {
    multiple: false,
    formatsAllowed: ".jpg,.png,.gif,.jpeg",
    maxSize: 50,
    uploadAPI: {
      url: Global.url + 'upload-image',
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
    this.is_edit = true;
    this.page_title = "Editar Articulo";
    this.url = Global.url;
  }

  ngOnInit(): void {
    this.getArticle();
  }

  onSubmit() {
    this._articleService.update(this.article._id,this.article).subscribe(
      (response) => {
        if (response.status == 'success') {
          this.status = 'success';
          this.article = response.article;
          console.log(response);
          
          Swal.fire({
            title: 'Articulo editado',
            text: 'Su articulo ha sido editado exitosa mente',
            icon: 'success',
            confirmButtonText: 'Perfecto!'
          });

          this._router.navigate(['/blog/articulo',this.article._id]);
        }
        else {
          this.status = 'error de status';
          console.log(this.status);
          console.log(response);
          Swal.fire({
            title: 'Articulo NO editado',
            text: 'Su articulo no se edito',
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

  imageUpload(data: any) {
    //let image_data = JSON.parse(data.body); 
    //alert(data.body.image);    
    this.article.image = data.body.image;
  }

  getArticle(){
    this._route.params.subscribe(params =>{
      let id = params['id'];
      //llamar servicio
      this._articleService.getArticle(id).subscribe(
      response=>{
        if(response.article)
        {
          this.article = response.article;
        }
        else{
          this._router.navigate(['./home']);
        }
        //console.log(response);
      },
      error =>{
        console.log(error);
        this._router.navigate(['./home']);
      }
      );
    });
    
  }
}
