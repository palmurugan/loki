import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, retry } from 'rxjs/internal/operators';

@Injectable({
    providedIn: 'root'
})
export class GlobalService {

    constructor(private http: HttpClient) { }

    postService(url: string, data: any, operation: string) {
        return this.http.post(url, data).pipe(retry(3), catchError(this.handleError<any[]>(operation, [])));
    }

    putService(url: string, data: any, operation: string) {
        return this.http.put(url, data).pipe(retry(3), catchError(this.handleError<any[]>(operation, [])));
    }

    getService(url: string, operation: string) {
        return this.http.get(url).pipe(retry(3), catchError(this.handleError<any[]>(operation, [])));
    }

    deleteService(url: string, operation: string) {
        return this.http.delete(url).pipe(retry(3), catchError(this.handleError<any[]>(operation, [])));
    }

    /**
    * Handle Http operation that failed.
    * Let the app continue.
    * @param operation - name of the operation that failed
    * @param result - optional value to return as the observable result
    */
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

            // TODO: send the error to remote logging infrastructure
            console.error(error); // log to console instead

            // Let the app keep running by returning an empty result.
            return of(result as T);
        };
    }
}