import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../services/article.service';
import { Article } from '../../models/article';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Global } from '../../services/global';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.css'],
  providers: [ArticleService]
})
export class ArticleDetailsComponent implements OnInit {
  public article!: Article;
  public url!: string;
  constructor(
    private _articleService: ArticleService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.url = Global.url;
  }

  ngOnInit(): void {
    this._route.params.subscribe(params => {
      let id = params['id'];
      //llamar servicio
      this._articleService.getArticle(id).subscribe(
        response => {
          if (response.article) {
            this.article = response.article;
          }
          else {
            this._router.navigate(['./home']);
          }
          //console.log(response);
        },
        error => {
          console.log(error);
          this._router.navigate(['./home']);
        }
      );
    });

  }


  delete(id: any) {
    Swal.fire({
      title: 'Cuidado!!!',
      text: "No podras revertir esto",
      icon: 'warning',
      showCancelButton: true,
      cancelButtonText: "Mejor no...",
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Borralo!'
    }).then((result) => {
      if (result.isConfirmed) {
        

        this._articleService.delete(id).subscribe(
          response => {
            Swal.fire(
              'Borrado!',
              'Articulo eliminado.',
              'success'
            )
            console.log("articulo eliminado");
            this._router.navigate(['/blog']);
          },
          error => {
            console.log(error);
            // this._router.navigate(['/blog']);
          }
        );

      }else{
        Swal.fire(
          'Tranquilo, nada se ha borrado'
        )
      }
    })


    
  }

}
